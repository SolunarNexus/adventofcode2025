package org.example

fun main() {
    val solution = Solution()
    val part1 = solution.sumOfTwoPartIds()
    val part2 = solution.sumOfMultiplePartIds()
    println("Part 1: sum of invalid ids = $part1")
    println("Part 2: sum of invalid ids = $part2")

    if (solution.isTest) {
        assert(part1 == 1227775554L)
        assert(part2 == 4174379265L)
        println("Solution verified for TEST")
    } else {
        assert(part1 == 26255179562L)
        assert(part2 == 31680313976L)
        println("Solution verified for PROD")
    }
}