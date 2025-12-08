package org.example

fun main() {
    val test = false
    val inputPath = if (test) "day-07-laboratories/src/main/resources/test_input.txt" else "day-07-laboratories/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.beamSplitSum()
//    val part2 = solution.answersWithCephalopodMath().sum()
    println("Part 1: tachyon beam splits ${part1}x")
//    println("Part 2: the grand total of all the answers applying cephalopod math is $part2")

    if (test) {
        assertResults(21, part1, "Incorrect beam split count for part one")
//        assertResults(6171290547579L, part2, "Incorrect grand total for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(1524, part1, "Incorrect beam split count for part one")
//        assertResults(8811937976367L, part2, "Incorrect grand total for part two")
//        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}