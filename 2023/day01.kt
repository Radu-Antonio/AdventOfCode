import java.io.*;

fun part1() {
    var ans = 0
    File("input.txt").bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val numbers = line.filter { ch -> ch.isDigit() }
            ans += numbers[0].toString().toInt() * 10 + numbers[numbers.length - 1].toString().toInt()
        }
    }
    println(ans)
}

fun part2() {
    var ans = 0
    val digits = listOf(
        "one", "two", "three", "four", "five", "six", "seven", "eight",
        "nine", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    )
    val strToDigit = mutableMapOf<String, Int>()
    strToDigit["one"] = 1
    strToDigit["two"] = 2
    strToDigit["three"] = 3
    strToDigit["four"] = 4
    strToDigit["five"] = 5
    strToDigit["six"] = 6
    strToDigit["seven"] = 7
    strToDigit["eight"] = 8
    strToDigit["nine"] = 9
    strToDigit["0"] = 0
    strToDigit["1"] = 1
    strToDigit["2"] = 2
    strToDigit["3"] = 3
    strToDigit["4"] = 4
    strToDigit["5"] = 5
    strToDigit["6"] = 6
    strToDigit["7"] = 7
    strToDigit["8"] = 8
    strToDigit["9"] = 9

    File("input.txt").bufferedReader().useLines { lines ->
        lines.forEach { line ->
            var (firstDigit, secondDigit) = "0" to "0"
            var (minIndex, maxIndex) = line.length to -1
            
            for (digit in digits) {
                var firstAppearence = line.indexOf(digit)
                var lastAppearence = line.lastIndexOf(digit)

                if (minIndex > firstAppearence && firstAppearence != -1) {
                    minIndex = firstAppearence
                    firstDigit = digit
                }

                if (maxIndex < lastAppearence) {
                    maxIndex = lastAppearence
                    secondDigit = digit
                }
            }
            ans += (strToDigit[firstDigit]?.let { it } ?: 0) * 10 + (strToDigit[secondDigit]?.let { it } ?: 0)
        }
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
