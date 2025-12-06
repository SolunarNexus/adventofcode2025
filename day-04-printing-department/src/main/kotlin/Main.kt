package org.example

fun main() {
    val test = true
    val inputPath = if (test) "day-03-lobby/src/main/resources/test_input.txt" else "day-03-lobby/src/main/resources/input.txt"

    val solution = Solution(inputPath)
//    val part1 = ...
//    val part2 = ...
//    println("Part 1 $part1")
//    println("Part 2 $part2")

    if (test) {
//        assertResults(...)
//        assertResults(...)
//        println("Solution verified for TEST")
    } else {
//        assertResults(...)
//        assertResults(...)
//        println("Solution verified for PROD")
    }
}

fun assertResults(expected: Long, actual: Long, part: String){
    assert(expected == actual, { "Incorrect total joltage for part $part. Was $actual, expected $expected" })
}