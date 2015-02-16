object Multiply {
  def nTimesM(n: Int)(m: Int) = n * m
  val times2 = nTimesM(2)(_)

  def main(args: Array[String]) {
    assert(args.size == 2, "Usage: Multiply <n> <m>")

    val n = args(0).toInt
    val m = args(1).toInt

    assert(nTimesM(n)(m) == (n * m))
    assert(times2(n) == (2 * n))
  }
}
