object Partial {
  def adder(x: Int, y: Int) = x + y
  val add2 = adder(2, _: Int)

  def main(args: Array[String]) {
    assert(args.size == 2, "Usage: Partial <x> <y>")

    val x = args(0).toInt
    val y = args(1).toInt

    assert(adder(x, y) == (x + y))
    assert(add2(x) == (x + 2))
  }
}
