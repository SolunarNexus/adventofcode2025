package org.example

fun main() {
    val test = false
    val inputPath = if (test) "day-07-laboratories/src/main/resources/test_input.txt" else "day-07-laboratories/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.beamSplitSum()
    val part2 = solution.quantumBeamSplitSum()
    println("Part 1: tachyon beam splits ${part1}x")
    println("Part 2: quantum tachyon beam splits ${part2}x")

    if (test) {
        assertResults(21, part1, "Incorrect beam split count for part one")
        assertResults(40L, part2, "Incorrect grand total for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(1524, part1, "Incorrect beam split count for part one")
        assertResults(32982105837605L, part2, "Incorrect grand total for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}