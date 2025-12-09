package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-08-playground/src/main/resources/test_input.txt" else "day-08-playground/src/main/resources/input.txt"
    val connectionsAvailable = if (test) 10 else 1000

    val solution = Solution(inputPath)
    val circuits = solution.circuits(connectionsAvailable)
    val circuitSizes = circuits.map { it.size }.sortedDescending()
    val part1 = circuitSizes.take(3).fold(1) { acc, i -> acc * i }
    circuits.sortedBy { it.size }.forEach { println(it.joinToString(separator = " ")) }
    println("Circuit sizes sorted: $circuitSizes (n=${circuitSizes.size})")

//    val part2 = solution.quantumBeamSplitSum()
    println("Part 1: product of the first three biggest circuits = $part1")
//    println("Part 2: quantum tachyon beam splits ${part2}x")

    if (test) {
        assertResults(40, part1, "Incorrect sum for the first three biggest circuits for part one")
//        assertResults(40L, part2, "Incorrect grand total for part two")
        println("Solution verified for TEST")
    } else {
        assertResults(105952, part1, "Incorrect sum for the first three biggest circuits for part one")
//        assertResults(32982105837605L, part2, "Incorrect grand total for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}