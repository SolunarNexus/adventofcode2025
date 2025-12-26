package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-12-tree-farm/src/main/resources/test_input.txt" else "day-12-tree-farm/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.fittingRegions()
    println("Part 1: the number of regions that fit all presents is $part1")

    if (test) {
        assertResults(2, part1, "Incorrect number of regions for part one")
        println("Solution verified for TEST")
    } else {
        assertResults(521, part1, "Incorrect number of paths for part one")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}