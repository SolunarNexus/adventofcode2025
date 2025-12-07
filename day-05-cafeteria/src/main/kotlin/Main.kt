package org.example

fun main() {
    val test = false
    val inputPath = if (test) "day-05-cafeteria/src/main/resources/test_input.txt" else "day-05-cafeteria/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val part1 = solution.freshIngredientsCount()
//    val part2 = solution.totalJoltage(12)
    println("Part 1: fresh ingredients count is $part1")
//    println("Part 2 total joltage is $part2")

    if (test) {
        assertResults(3, part1, "one")
//        assertResults(3121910778619L, part2, "two")
        println("Solution verified for TEST")
    } else {
        assertResults(661, part1, "one")
//        assertResults(169709990062889L, part2, "two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String){
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}