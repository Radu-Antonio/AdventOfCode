import java.io.*;

fun part1() {
    var ans = 0
    File("input.txt").bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val cubes = line.replace("[,;:]".toRegex(), "")
                .split(" ")
            var isValid = true
            val id = cubes[1]

            for (idx in 2 until cubes.size step 2 ) {
                val (amount, color) = cubes.subList(idx, idx+2)
                if (color == "red" && amount.toInt() > 12 ||
                    color == "green" && amount.toInt() > 13 ||
                    color == "blue" && amount.toInt() > 14) {
                    isValid = false
                    break
                }
            }
            if (isValid) ans += id.toInt();
        }
    }
    println(ans)
}

fun part2() {
    File("input.txt").bufferedReader().useLines { lines ->
        var ans = 0
        lines.forEach { line ->
            val cubes = line.replace("[,;:]".toRegex(), "")
                .split(" ")
            var (r, g, b) = listOf(0, 0, 0)

            for (idx in 2 until cubes.size step 2 ) {
                val (amount, color) = cubes.subList(idx, idx+2)
                when (color) {
                    "red" -> r = maxOf(r, amount.toInt())
                    "green" -> g = maxOf(g, amount.toInt())
                    "blue" -> b = maxOf(b, amount.toInt())
                }
            }
            ans += r * g * b
        }
        println(ans)
    }
}

fun main() {
    part1()
    part2()
}
