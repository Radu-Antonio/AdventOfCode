import java.io.*;

fun part1() {
    val text = File("input.txt").readText().split(Regex("\\r\\n"))
    val times = text[0].split(":")[1].strip().split("\\s+".toRegex()).map { it.toInt() }
    val dist = text[1].split(":")[1].strip().split("\\s+".toRegex()).map { it.toInt() }
    var ans = 1

    for ((t, d) in times.zip(dist)) {
        var numOfWays = 0

        for (speed in 1 until t) {
            if (speed * (t - speed) > d)
                numOfWays++
        }
        ans *= numOfWays
    }
    println(ans)
}

// too brute force but it worked, better was to start at the heads of the
// intervals and go till the record was broken

fun part2() {
    val text = File("input.txt").readText().split(Regex("\\r\\n"))
    val time = Regex("\\d+").findAll(text[0]).map { it.value }.joinToString("").toLong()
    val dist = Regex("\\d+").findAll(text[1]).map { it.value }.joinToString("").toLong()
    var ans = 0

    for (speed in 1 until  time) {
        if (speed * (time - speed) > dist)
            ans++
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
