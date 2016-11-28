class Rational(n: Int, d: Int) {
  override def toString = n + "/" + d
}

val number = new Rational(1,2)
println(number)
