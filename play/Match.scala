object Match {
  def matchValue(i: Int) = i match {
    case 1 => "one"
    case 2 => "two"
    case _ => "unknown value"
  }

  def matchType(o: Any) = o match {
    case i: Int => s"Int: ${i}"
    case s: String => s"String: ${s}"
    case _ => "unknown type"
  }

  case class Case(i: Int, s: String)
  def matchCaseClass(c: Case) = c match {
    case Case(i, s) => s"${i} => ${s}"
    case _ => "unkown case class"
  }

  def matchTuple(t: (Int, String)) = t match {
    case (i, s) => s"${i} => ${s}"
    case _ => "unkown tuple"
  }

  def main(args: Array[String]) {
    assert(args.size == 2, "Usage: Match <i> <s>")

    val i = args(0).toInt
    val s = args(1)

    println(s"matchValue(${i}): ${matchValue(i)}")
    println(s"matchType(${i}): ${matchType(i)}")
    println(s"matchType(${s}): ${matchType(s)}")
    println(s"matchCaseClass(Case(${i}, ${s}): ${matchCaseClass(Case(i, s))}")
    println(s"matchTuple((${i}, ${s}): ${matchTuple((i, s))}")
  }
}
