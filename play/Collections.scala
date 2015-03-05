import scala.collection.immutable.{TreeMap, ListMap}

object Collections {
  val blessing = "I have known many, liked not a few, loved only one, I drink to you. May you live as long as you want, and never want as long as you live. May the grass grow long on the road to hell for want of use. May you live to be a hundred years, with one extra year to repent. As you slide down the banisters of life may the splinters never point the wrong way. May your troubles be as few and as far apart as my Grandmothers teeth. May the roof above us never fall in, and may we friends gathered below never fall out. May there be a generation of children on the children of your children. May the Lord keep you in His hand and never close His fist too tight. May your neighbors respect you, Trouble neglect you, The angels protect you, And heaven accept you. May your pockets be heavy and your heart be light, may good luck pursue you each morning and night. May the strength of three be in your journey. In the New Year, may your right hand always be stretched out in friendship and never in want. Here's that we may always have a clean shirt, a clean conscience, and a guinea in our pocket. May I see you grey and combing your children's hair. May you die in bed at ninety-five years, shot by a jealous husband or wife. May your doctor never earn a dollar out of you and may your heart never give out. May the ten toes of your feet steer you clear of all misfortune, and before you're much older, may you hear much better toasts than this. May you have the hindsight to know where you've been, the foresight to know where you're going and the insight to know when you're going too far. May you be poor in misfortune, rich in blessings, slow to make enemies, quick to make friends. But rich or poor, quick or slow, may you know nothing but happiness from this day foward. May the frost never afflict your spuds. May the outside leaves of your cabbage always be free from worms. May the crow never pick your haystack, and may your donkey always be in foal. May the sound of happy music, And the lilt of Irish laughter, fill your heart with gladness, that stays forever after. May the hinges of our friendship never grow rusty. May you live long, Die happy, And rate a mansion in heaven. Beautiful young people are acts of nature, But beautiful old people are works of art."

  val sentences = blessing.split("\\.").map(_.trim).toList

  val words = sentences.flatMap(_.split(" ")).map(_.toLowerCase).map(_.replace(',', ' ')).map(_.trim)

  val wordsByAlphabet = TreeMap[Char, List[String]]() ++ words.groupBy(_.head).map{case (k, v) => (k -> v.sorted.distinct)}

  val wordsByLength = TreeMap[Int, List[String]]() ++ words.groupBy(_.size).map{case (k, v) => (k -> v.sorted.distinct)}

  val wordsByLengthHistogram = TreeMap[Int, (Int, Int)]() ++ words.groupBy(_.size).map{case (k, v) => k -> (v.distinct.size, v.size)}

  def lt(t0: (Int, Int), t1: (Int, Int)) = (t0._2 - t0._1) < (t1._2 - t1._1)

  val (wordsByLengthHistogramEven, wordsByLengthHistogramOdd) = wordsByLengthHistogram.partition{case (k, v) => (k % 2) == 0}

  val wordsHistogram = ListMap[String, Int]() ++ words.groupBy(w => w).map{case (k, v) => k -> v.size}.toList.sortBy(_._2)

  val wordCombinations = words.combinations(2).take(100).toList

  val l = 1 :: 2 :: Nil
  val ll = List(2, 3)
  val lll = l ++ ll
  val llll = lll :+ 5
  val lllll = 0 +: llll
  val llllll = -1 :: lllll
  val lllllll = llllll.map(_.toString)

  def d(l: List[Int]): String = l match {
    case head :: tail => s"${d(tail)}->${head}"
    case Nil => ""
    case _ => "ERROR"
  }

  def main(args: Array[String]): Unit = {
    println(blessing); println("---")
    println(sentences); println("---")
    println(words); println("---")

    println(wordsByAlphabet); println("---")
    println(wordsByLength); println("---")
    println(wordsByLengthHistogram); println("---")
    println(wordsByLengthHistogram.maxBy{case (k, v) => v match {case (d, s) => s - d}}); println("---")
    // println(wordsByLengthHistogram.sortWith(((k, v), (kk, vv)) => lt(v, vv)); println("---")
    println(wordsByLengthHistogramOdd); println("---")
    println(wordsByLengthHistogramEven); println("---")
    println(wordsHistogram); println("---")
    println(wordCombinations); println("---")
    println(wordCombinations.transpose); println("---")

    println(llllll); println("---")
    println(d(llllll)); println("---")
    println(llllll.corresponds(lllllll)((a, b) => a.toString == b)); println("---")
    println(lll.diff(ll)); println("---")
    println(lll.intersect(ll)); println("---")
    println(llllll.fold(0)(_ - _)); println("---")
    println(llllll.foldLeft(0)(_ - _)); println("---")
    println(llllll.foldRight(0)(_ - _)); println("---")
    println(llllll.reduce(_ - _)); println("---")
    println(llllll.reduceLeft(_ - _)); println("---")
    println(llllll.reduceRight(_ - _)); println("---")
  }
}
