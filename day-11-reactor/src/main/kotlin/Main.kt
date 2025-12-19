package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-11-reactor/src/main/resources/test_input.txt" else "day-11-reactor/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.paths()
    val part2 = solution.pathsWithRequiredDevices()
    println("Part 1: the number of paths leading from you to out is $part1")
    println("Part 2: the number of paths leading from svr to out (through dac and fft) is $part2")

    if (test) {
        assertResults(5, part1, "Incorrect number of paths for part one")
        assertResults(2, part2, "Incorrect number of paths for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(683, part1, "Incorrect number of paths for part one")
        assertResults(533996779677200L, part2, "Incorrect sum of button presses for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}