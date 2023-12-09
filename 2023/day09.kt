import java.io.*;

fun part1() {
    val lines = File("input.txt").readLines().map { it.split("\\s+".toRegex()).map { x -> x.toInt() } }
    var ans = 0

    for (line in lines) {
        val nums = line.toMutableList()

        while (!nums.all { it == 0 }) {
            for (i in 0 until nums.size-1) {
                nums[i] = nums[i + 1] - nums[i]
            }
            ans += nums.removeLast()
        }
    }
    println(ans)
}

fun part2() {
    val lines = File("input.txt").readLines().map { it.split("\\s+".toRegex()).map { x -> x.toInt() } }
    var ans = 0

    for (line in lines) {
        val nums = line.toMutableList()
        val fst = emptyList<Int>().toMutableList()
        var acc = 0

        while (!nums.all { it == 0 }) {
            fst.add(nums[0])
            for (i in 0 until nums.size-1) {
                nums[i] = nums[i + 1] - nums[i]
            }
            nums.removeLast()
        }
        
        for (num in fst.reversed()) {
            acc = num - acc
        }
        ans += acc
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
