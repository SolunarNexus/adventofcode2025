package org.example

fun main() {
    Solution().idsOfMultipleEqualSequences().forEach { println("$it") }
    println("Sum of IDs: ${Solution().sumOfInvalidIDs()}")
}