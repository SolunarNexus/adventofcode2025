package org.example

import java.io.File

fun main() {
    val test = true
    val inputPath =
        if (test) "day-04-printing-department/src/main/resources/test_input.txt"
        else "day-04-printing-department/src/main/resources/input.txt"

    println(File(inputPath).readText() + '\n')
    val solution = Solution(inputPath)
    val part1 = solution.accessibleRolls()
    val part2 = solution.allRemovableRolls()
    println("Part 1: accessible rolls = $part1")
    println("Part 2: all removable rolls =  $part2")

    if (test) {
        assertResults(13, part1, "Incorrect accessible rolls count for part one")
        assertResults(43, part2, "Incorrect all removable rolls count for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(1527, part1, "Incorrect accessible rolls count for part one")
        assertResults(8690, part2, "Incorrect all removable rolls count for part two")
        println("Solution verified for PROD")
    }
}

fun assertResults(expected: Int, actual: Int, message: String) {
    assert(expected == actual, { "$message. Was $actual, expected $expected" })
}