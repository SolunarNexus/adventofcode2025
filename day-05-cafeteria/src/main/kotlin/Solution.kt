package org.example

import java.io.File

class Solution {
    val inputPath: String

    constructor(inputPath: String) {
        this.inputPath = inputPath
    }

    fun freshIngredientsCount(): Int = freshIngredientIds().size

    private fun freshIngredientIds(): List<Long> {
        val database = File(inputPath).inputStream().bufferedReader().readText().split("\n\n")
        val ranges = database[0].lines().map {
            Pair(it.substringBefore('-'), it.substringAfter('-'))
        }
        val available = database[1].lines().map { it.toLong() }
        val freshIds = mutableListOf<Long>()

        for (id in available) {
            if (ranges.any { (start, end) -> id in start.toLong()..end.toLong() }) {
                freshIds.add(id)
            }
        }

        println("Fresh ingredients IDs are: ${freshIds.joinToString(", ")}")
        return freshIds
    }
}