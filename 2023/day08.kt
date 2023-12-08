import java.io.*;

fun part1() {
    val text = File("input.txt").readLines()
    var moves = text[0]
    val neighbour = HashMap<String, List<String>>()
    var start = "AAA"
    var ans = 0

    for (line in text.subList(2,text.size-1)) {
        val (src, dest) = line.split(" = ")
        val (left, right) = dest.substring(1, dest.length-1).split(", ")
        neighbour[src] = listOf(left, right)
    }

    while (start != "ZZZ") {
        ans++
        start = if (moves[0] == 'L') {
            neighbour[start]!![0]
        } else {
            neighbour[start]!![1]
        }
        moves = moves.substring(1) + moves[0]
    }
    println(ans)
}

fun part2() {

}

fun main() {
    part1()
    part2()
}
