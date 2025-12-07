package org.example

import java.io.File

class Solution {
    val inputPath: String
    val input: List<String>
    val operations: List<String>

    constructor(inputPath: String) {
        this.inputPath = inputPath
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
        this.operations = input.last().trim().split("\\s+".toRegex())
    }

    fun answers(): List<Long> {
        val worksheet = input.dropLast(1).flatMap { row ->
            row.trim().split("""\s+""".toRegex()).withIndex()
        }.groupBy({ it.index }, { it.value.toLong() })

        val answers = operations.withIndex().map { (index, symbol) ->
            worksheet.getValue( index ).reduce { a, b ->
                if (symbol == "*") a * b
                else a + b
            }
        }

        println("Answers to problems are: ${answers.joinToString(", ")}")
        return answers
    }

    fun answersWithCephalopodMath(): List<Long> {
        val numbers = input.first().indices
            .map { input.columnAsLongOrNull(it) }
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