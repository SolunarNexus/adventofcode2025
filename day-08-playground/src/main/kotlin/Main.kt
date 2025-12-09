package org.example

fun main() {
    val test = false
    val inputPath =
        if (test) "day-08-playground/src/main/resources/test_input.txt" else "day-08-playground/src/main/resources/input.txt"
    val connectionsAvailable = if (test) 10 else 1000

    val solution = Solution(inputPath)
    val part1 = solution.circuits(connectionsAvailable)
    val circuitSizes = part1.map { it.size }.sortedDescending()
    val sizes = circuitSizes.take(3).fold(1) { acc, i -> acc * i }
    println("Circuit sizes sorted: $circuitSizes (n=${circuitSizes.size})")
    println("Part 1: product of the first three biggest circuits = $sizes")

    val part2 = solution.superCircuit()
    val coordProduct = part2.second.first.first * part2.second.second.first
    val superCircuitSizes = part2.first.map { it.size }.sortedDescending()
    println("Circuit sizes sorted: $superCircuitSizes (n=${superCircuitSizes.size})")
    println("Part 2: product of the last junction box's coordinates =  $coordProduct")

    if (test) {
        assertResults(40, sizes, "Incorrect sum for the first three biggest circuits for part one")
        assertResults(25272, coordProduct, "Incorrect product of the coordinates part two")
        println("Solution verified for TEST")
    } else {
        assertResults(105952, sizes, "Incorrect sum for the first three biggest circuits for part one")
        assertResults(975931446L, coordProduct, "Incorrect sum for the first three biggest circuits for part two")
        println("Solution verified for PROD")
    }
}

fun <T> assertResults(expected: T, actual: T, message: String) {
    assert(expected == actual) { "$message. Was $actual, expected $expected" }
}