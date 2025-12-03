package org.example

fun main() {
    val invalidIDs = Solution().invalidIDs()
    println("Invalid IDs: ${invalidIDs.joinToString { it.toString()} }}")
    println(invalidIDs.sum())
}