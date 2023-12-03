import java.io.*;
import java.util.*

fun extractNumber(grid: List<MutableList<Char>>, r: Int, col: Int): Int {
    var c = col
    if (grid[r][c].isDigit()) {
        val digits = mutableListOf<Char>()
        while (c > 0 && grid[r][c-1].isDigit())
            c -= 1

        while (c < grid[0].size && grid[r][c].isDigit()) {
            digits.add(grid[r][c])
            grid[r][c] = '.'
            c += 1
        }
        return digits.joinToString("").toInt()
    }
    return 0
}

fun part1() {
    var ans = 0
    val lines = File("input.txt").readLines()
    var grid = lines.map { it.toCharArray().toMutableList() }
    val dirs = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
    val q = LinkedList<Pair<Int, Int>>()

    grid.forEachIndexed { i, line ->
        line.forEachIndexed { j, ch ->
            if (!ch.isDigit() && ch != '.')
                q.add(i to j)
        }
    }

    for ((x, y) in q) {
        for ((a, b) in dirs) {
            val (r, c) = listOf(x + a, y + b)
            ans += extractNumber(grid, r, c)
        }
    }
    println(ans)
}

fun part2() {
    var ans = 0
    val lines = File("input.txt").readLines()
    var grid = lines.map { it.toCharArray().toMutableList() }
    val dirs = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
    val q = LinkedList<Pair<Int, Int>>()

    grid.forEachIndexed { i, line ->
        line.forEachIndexed { j, ch ->
            if (ch == '*')
                q.add(i to j)
        }
    }

    for ((x, y) in q) {
        val numbers = mutableListOf<Int>()
        for ((a, b) in dirs) {
            if (numbers.size > 2)
                break
            var (r, c) = listOf(x + a, y + b)
            val num = extractNumber(grid, r, c)
            if (num != 0)
                numbers.add(num)
        }
        if (numbers.size == 2)
            ans += numbers[0] * numbers[1]
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
