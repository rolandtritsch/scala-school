object Foo {
  def apply() = new Foo()
  def apply(t: String) = new Foo(t)
}

class Foo(val text: String) {
  def this() = this("")
}

object Apply {
  def main(args: Array[String]) {
    assert(args.size == 1, "Usage: Apply <text>")

    val text = args(0)

    val foo = Foo()
    assert(foo.text == "")

    val fooText = Foo(text)
    assert(fooText.text == text)
  }
}
