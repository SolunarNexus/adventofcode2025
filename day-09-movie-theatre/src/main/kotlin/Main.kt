package org.example

fun main() {
    val test = true
    val inputPath =
        if (test) "day-09-movie-theatre/src/main/resources/test_input.txt" else "day-09-movie-theatre/src/main/resources/input.txt"

    val solution = Solution(inputPath)
    val coords = solution.coordinates()
    coords.forEach { println(it) }
//    val part1 = solution.circuits(connectionsAvailable)
//    val part2 = solution.superCircuit()
//    println("Part 1: product of the first three biggest circuits = $sizes")
//    println("Part 2: product of the last junction box's coordinates =  $coordProduct")

    if (test) {
//        assertResults(40, sizes, "Incorrect sum for the first three biggest circuits for part one")
//        assertResults(25272, coordProduct, "Incorrect product of the coordinates part two")
//        println("Solution verified for TEST")
    } else {
//        assertResults(105952, sizes, "Incorrect sum for the first three biggest circuits for part one")
//        assertResults(975931446L, coordProduct, "Incorrect sum for the first three biggest circuits for part two")
//        println("Solution verified for PROD")
    }
}