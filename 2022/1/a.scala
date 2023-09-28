import scala.collection.mutable.Queue

@main def day1a = {
  val lines = scala.io.Source.fromFile("2022/1/data.txt").getLines.toArray
  var sums: Queue[Int] = Queue()
  var currentSum = 0

  val highestSum = {
    for (line <- lines)
      if !line.isEmpty() then currentSum += line.toInt
      else { sums += currentSum; currentSum = 0 }
    sums.max
  }
  println(highestSum)
}
