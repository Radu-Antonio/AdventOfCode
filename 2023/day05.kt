import java.io.*;

fun part1() {
    val text = File("input.txt").readText().split(Regex("\\r\\n\\r\\n")) // i hate this
    var seeds = text[0].split(":")[1].strip().split("\\s".toRegex()).map { it.toLong() }

    for (chunk in text.subList(1, text.size)) {
        val intervals = chunk.split(":")[1].strip().split("\\r\\n".toRegex()).map { it.split(" ").map { x -> x.toLong() } }
        val ranges = HashMap<Pair<Long, Long>, Long>()

        for ((dest, src, len) in intervals) {
            ranges[src to src + len - 1] = dest - src
        }

        seeds = seeds.map { seed ->
            for ((p, mapVal) in ranges) {
                val (start, stop) = p
                if (seed in start..stop) {
                    return@map seed + mapVal
                }
            }
            return@map seed
        }
    }
    println(seeds.min())
}

fun part2() {
    // intervals.. idk
}

fun main() {
    part1()
    part2()
}
