package org.example

import java.io.File

class Solution {
    val inputPath: String

    constructor(inputPath: String) {
        this.inputPath = inputPath
    }

    fun grandTotal(): Long = answers().sum()

    private fun answers(): List<Long> {
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
}