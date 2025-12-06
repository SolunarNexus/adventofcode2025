package org.example

fun main() {
    val solution = Solution(test = false)
    val totalJoltage = solution.totalJoltage()
    println("Total joltage is $totalJoltage")

    if (solution.isTest) {
        val expectedTotalJoltage = 357L
        assert(
            totalJoltage == expectedTotalJoltage,
            { "Incorrect total joltage. Was $totalJoltage, expected $expectedTotalJoltage" })
        println("Solution verified for TEST")
    } else {
        val expectedTotalJoltage = 17113L
        assert(
            totalJoltage == expectedTotalJoltage,
            { "Incorrect total joltage. Was $totalJoltage, expected $expectedTotalJoltage" })
        println("Solution verified for PROD")
    }
}