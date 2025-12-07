package org.example

fun main() {
    val test = true
    val inputPath = if (test) "day-04-cafeteria/src/main/resources/test_input.txt" else "day-03-lobby/src/main/resources/input.txt"

    val solution = Solution(inputPath)
//    val part1 = solution.totalJoltage(2)
//    val part2 = solution.totalJoltage(12)
//    println("Part 1 total joltage is $part1")
//    println("Part 2 total joltage is $part2")

    if (test) {
//        assertResults(357L, part1, "one")
//        assertResults(3121910778619L, part2, "two")
//        println("Solution verified for TEST")
    } else {
//        assertResults(17113L, part1, "one")
//        assertResults(169709990062889L, part2, "two")
//        println("Solution verified for PROD")
    }
}

fun assertResults(expected: Long, actual: Long, message: String){
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}