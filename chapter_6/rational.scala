// Class parameters
// Will be the entry point of the class
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = greaterCommonDivisor(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor
  // Every auxiliary constructor must invoke another constructor
  // of the same class as its first action
  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if(this.lessThan(that)) that else this

  private def greaterCommonDivisor(a: Int, b: Int): Int =
    if(b == 0) a else greaterCommonDivisor(b, a % b)

  override def toString = numer + "/" + denom
}

val oneHalf = new Rational(1,2)
val twoThirds = new Rational(2,3)
val sum = oneHalf * twoThirds
println(s"SUM: $oneHalf + $twoThirds = $sum")

val defaultDenominator = new Rational(10)
println(s"With default denominator: $defaultDenominator")

val reducedForm = new Rational(66, 42)
println(s"Reduced Form of 66/42: $reducedForm")

val operatingWithInt = reducedForm * 2
println(s"66/42 * 2 = $operatingWithInt")
