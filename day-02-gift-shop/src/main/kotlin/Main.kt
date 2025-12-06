package org.example

fun main() {
    val ids = Solution().idsOfTwoEqualSequences()
    println(ids.joinToString(","))
    println("Sum of IDs: ${ids.sum()}")
}