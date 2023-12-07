import java.io.*;
import java.util.*

fun cardToBase10(card: String, part: Int): Int {
    val charToNum = hashMapOf<Char, Int>()
    if (part == 1) {
        charToNum.apply { putAll(
            mapOf('2' to 0, '3' to 1, '4' to 2, '5' to 3, '6' to 4, '7' to 5, '8' to 6,
                '9' to 7, 'T' to 8, 'J' to 9, 'Q' to 10, 'K' to 11, 'A' to 12))
        }
    } else {
        charToNum.apply { putAll(
            mapOf('2' to 1, '3' to 2, '4' to 3, '5' to 4, '6' to 5, '7' to 6, '8' to 7,
                '9' to 8, 'T' to 9, 'J' to 0, 'Q' to 10, 'K' to 11, 'A' to 12))
        }
    }

    var num = 0
    var power = 13 * 13 * 13 * 13

    for (ch in card) {
        num += power * charToNum[ch]!!
        power /= 13
    }
    return num
}

fun getCardScore(card: String): Int {
    val freq: MutableMap<Int, Int?> =
        (0..5).associateWith { 0 }.toMutableMap()

    for (ch in "23456789TJQKA") {
        val c = card.count{ x -> x == ch }
        freq[c] = freq[c]?.plus(1)
    }

    var score = when {
        freq[5] == 1 -> 7_000_000                  // 5 of a kind
        freq[4] == 1 -> 6_000_000                  // 4 of a kind
        freq[3] == 1 && freq[2] == 1 -> 5_000_000  // full house
        freq[3] == 1 -> 4_000_000                  // 3 of a kind
        freq[2] == 2 -> 3_000_000                  // 2 pair
        freq[2] == 1 -> 2_000_000                  // 1 pair
        else -> 1_000_000                          // high card
    }

    return score + cardToBase10(card, 1)
}

fun getCardScoreJoker(card: String): Int {
    val freq: MutableMap<Int, Int?> =
        (0..5).associateWith { 0 }.toMutableMap()

    for (ch in "23456789TJQKA") {
        val c = card.count{ x -> x == ch }
        freq[c] = freq[c]?.plus(1)
    }
    val jokers = card.count{ x -> x == 'J' }

    var score = when {
        freq[5] == 1 -> 7_000_000                                                       // 5 of a kind
        freq[4] == 1 -> if (jokers > 0) 7_000_000 else 6_000_000                        // 4 of a kind
        freq[3] == 1 && freq[2] == 1 -> if (jokers > 0) 7_000_000 else 5_000_000        // full house
        freq[3] == 1 ->                                                                 // 3 of a kind
            when (jokers) {
                in listOf(1, 3) -> 6_000_000
                2    -> 7_000_000
                else -> 4_000_000
            }
        freq[2] == 2 ->                                                                 // 2 pair
            when (jokers) {
                1 -> 5_000_000
                2 -> 6_000_000
                else -> 3_000_000
            }
        freq[2] == 1 -> if (jokers in 1..2) 4_000_000 else 2_000_000               // 1 pair
        else -> if (jokers == 1) 2_000_000 else 1_000_000                               // high card
    }

    return score + cardToBase10(card, 2)
}

fun part1() {
    val text = File("input.txt").readText().lines()
    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

    minHeap.addAll(text.map { line ->
        val (card, bet) = line.split(" ")
        return@map getCardScore(card) to bet.toInt()
    })

    var rank = 1
    var ans = 0L

    while (minHeap.isNotEmpty()) {
        val (_, bet) = minHeap.poll()
        ans += rank * bet
        rank++
    }
    println(ans)
}

fun part2() {
    val text = File("input.txt").readText().lines()
    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

    minHeap.addAll(text.map { line ->
        val (card, bet) = line.split(" ")
        return@map getCardScoreJoker(card) to bet.toInt()
    })

    var rank = 1
    var ans = 0L

    while (minHeap.isNotEmpty()) {
        val (_, bet) = minHeap.poll()
        ans += rank * bet
        rank++
    }
    println(ans)
}

fun main() {
    part1()
    part2()
}
