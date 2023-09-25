import scala.collection.mutable.Queue

// Top n calorie-holders to sum
val n = 3

val lines = scala.io.Source.fromFile("2022/1/data.txt").getLines.toArray

var sums: Queue[Int] = Queue()
var currentSum = 0

for (line <- lines)
  if !line.isEmpty() then currentSum += line.toInt
  else { sums += currentSum; currentSum = 0 }

sums = sums.sorted(Ordering[Int].reverse)
var sum = 0

for (i <- 0 until n)
  sum += sums(i)

println(sum)
