package org.example

import java.io.File

class Solution {
    val inputPath: String

    constructor(inputPath: String) {
        this.inputPath = inputPath
    }

    fun answers(): List<Long> {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
            .map { it.trim().split("\\s+".toRegex()) }
        val worksheet = lines.dropLast(1)
        val operations = lines.last()
        val answers = mutableListOf<Long>()

        for (i in 0..<worksheet.first().size) {
            if (operations[i] == "+") {
                answers.add(worksheet.sumOf { it[i].toLong() })
            } else if (operations[i] == "*") {
                answers.add(worksheet.fold(1L) { acc, row -> acc * row[i].toLong() })
            }
        }
        println("Answers to problems are: ${answers.joinToString(", ")}")
        return answers
    }

    fun answersWithCephalopodMath(): List<Long> {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
        val operations = lines.last().trim().split("\\s+".toRegex())
        val numbers = lines.first().indices
            .map { lines.columnAsLongOrNull(it) }
            .fold(mutableListOf(mutableListOf<Long>())) { carry, maybeNumbers ->
                when (maybeNumbers) {
                    null -> carry.apply { add(mutableListOf()) }
                    else -> carry.apply { last().add(maybeNumbers) }
                }
            }.mapIndexed { index, list -> index to list }.toMap()

        val answers = operations.withIndex().map { (index, symbol) ->
            numbers.getValue(index).reduce { a, b ->
                if (symbol == "*") a * b
                else a + b
            }
        }
        println("Answers to problems are: ${answers.joinToString(", ")}")
        return answers
    }

    private fun List<String>.columnAsLongOrNull(column: Int): Long? =
        dropLast(1).map { row -> row[column] }.joinToString("").trim().toLongOrNull()
}