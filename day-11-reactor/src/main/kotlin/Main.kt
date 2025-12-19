package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-11-reactor/src/main/resources/test_input.txt" else "day-11-reactor/src/main/resources/input.txt"

//    val solution = Solution(inputPath)
//    val part1 = solution.sumOfButtonPressesForLights()
//    val part2 = solution.sumOfButtonPressesForJoltage()
//    println("Part 1: the minimum number of button presses for correct light configuration is $part1")
//    println("Part 2: the minimum number of button presses for correct joltage configuration is $part2")

    if (test) {
//        assertResults(7, part1, "Incorrect sum of button presses for part one")
//        assertResults(33, part2, "Incorrect sum of button presses for part two")
        println("Solution verified for TEST")
    } else {
//        assertResults(558, part1, "Incorrect sum of button presses for part one")
//        assertResults(20317, part2, "Incorrect sum of button presses for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}