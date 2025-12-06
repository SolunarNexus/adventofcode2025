package org.example

import java.io.File

fun main() {
    val test = false
    val inputPath =
        if (test) "day-04-printing-department/src/main/resources/test_input.txt"
        else "day-04-printing-department/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.accessibleRolls()
    println(File(inputPath).readText())
    println("Part 1: accessible rolls = $part1")
//    val part2 = ...
//    println("Part 2 $part2")

    if (test) {
        assertResults(13, part1, "Incorrect accessible rolls count for part one")
//        assertResults(...)
        println("Solution verified for TEST")
    } else {
        assertResults(1527, part1, "Incorrect accessible rolls count for part one")
//        assertResults(...)
        println("Solution verified for PROD")
    }
}

fun assertResults(expected: Int, actual: Int, message: String) {
    assert(expected == actual, { "$message. Was $actual, expected $expected" })
}