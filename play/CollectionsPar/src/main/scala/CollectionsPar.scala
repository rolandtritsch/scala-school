object CollectionsParInstrument {
  val mr = new com.codahale.metrics.MetricRegistry()
}

trait CollectionsParInstrumented extends nl.grons.metrics.scala.InstrumentedBuilder {
  val metricRegistry = CollectionsParInstrument.mr
}

object CollectionsPar extends CollectionsParInstrumented {
  private[this] val seqFoldTimer = metrics.timer("seq-fold")
  private[this] val parFoldTimer = metrics.timer("par-fold")

  def main(args: Array[String]): Unit = {
    assert(args.size == 2, "Usage: CollectionsPar <numberOfSamples> <sizeOfArray>")

    val numberOfSamples = args(0).toInt
    val sizeOfArray = args(1).toInt

    val metrics = com.codahale.metrics.ConsoleReporter.forRegistry(CollectionsParInstrument.mr)
      .convertRatesTo(java.util.concurrent.TimeUnit.SECONDS)
      .convertDurationsTo(java.util.concurrent.TimeUnit.MILLISECONDS)
      .build()

    for(i <- 1 to numberOfSamples) seqFoldTimer.time {
      (1 to sizeOfArray).toArray.fold(0)(_ + _)
    }
    for(i <- 1 to numberOfSamples) parFoldTimer.time {
      (1 to sizeOfArray).toArray.par.fold(0)(_ + _)
    }

    metrics.report()
  }
}
