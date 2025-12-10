package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-09-movie-theatre/src/main/resources/test_input.txt" else "day-09-movie-theatre/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.largestRectangleArea()
    val part2 = solution.largestRectangleAreWithinBounds()
    println("Part 1: the largest rectangle area is $part1")
    println("Part 2: the largest rectangle area within bounds is $part2")

    if (test) {
        assertResults(50L, part1, "Incorrect rectangle area for part one")
        assertResults(24L, part2, "Incorrect rectangle area for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(4738108384L, part1, "Incorrect rectangle area for part one")
        assertResults(1513792010L, part2, "Incorrect rectangle area for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}