import java.io.*;

fun part1() {
    var ans = 0
    val lines = File("input.txt").readLines()

    lines.forEach {line ->
        var numOfFinds = 0
        val numbers = line.split(":")[1]
        val (winNumbers, ourNumbers) = numbers.split("|")
        val set = ourNumbers.split("\\s+".toRegex()).toHashSet()

        winNumbers.split("\\s+".toRegex()).filter { it.isNotBlank() }.forEach {num ->
            if (set.contains(num)) numOfFinds += 1
        }
        ans += 1 shl (numOfFinds - 1)
    }
    println(ans)
}

fun part2() {
    var ans = 0
    val lines = File("input.txt").readLines()
    val numOfCopies = MutableList<Int>(lines.size + 1) { 1 }

    lines.forEachIndexed() { idx, line ->
        var numOfFinds = 0
        val numbers = line.split(":")[1]
        val (winNumbers, ourNumbers) = numbers.split("|")
        val set = ourNumbers.split("\\s+".toRegex()).toHashSet()

        winNumbers.split("\\s+".toRegex()).filter { it.isNotBlank() }.forEach { num ->
            if (set.contains(num)) numOfFinds += 1
        }

        for (i in idx+1..idx+numOfFinds)
            numOfCopies[i] += numOfCopies[idx]
        ans += numOfCopies[idx + 1]
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
