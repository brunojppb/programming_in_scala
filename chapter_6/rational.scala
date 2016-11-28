class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n + "/" + d
}

val number = new Rational(1,2)
println(number)
