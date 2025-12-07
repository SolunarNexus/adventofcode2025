package org.example

fun main() {
    val test = false
    val inputPath = if (test) "day-06-trash-compactor/src/main/resources/test_input.txt" else "day-06-trash-compactor/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.answers().sum()
    val part2 = solution.answersWithCephalopodMath().sum()
    println("Part 1: the grand total of all the answers is $part1")
    println("Part 2: the grand total of all the answers applying cephalopod math is $part2")

    if (test) {
        assertResults(4277556L, part1, "Incorrect grand total for part one")
        assertResults(6171290547579L, part2, "Incorrect grand total for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(6171290547579L, part1, "Incorrect grand total for part one")
        assertResults(8811937976367L, part2, "Incorrect grand total for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}