package org.example

import java.io.File

class Solution {
    val inputPath = "day-03-lobby/src/main/resources/input.txt"
    val testInputPath = "day-03-lobby/src/main/resources/test_input.txt"
    var isTest: Boolean

    constructor(test: Boolean = false) {
        if (test) println("### Initializing TEST solution ###") else println("### Initializing PROD solution ###")
        this.isTest = test
    }

    fun totalJoltage(batteries: Int): Long {
        val inputPath: String = if (isTest) testInputPath else inputPath
        val banks = File(inputPath).inputStream().bufferedReader().readLines()
        var totalJoltage = 0L

        for (bank: String in banks) {
            val joltage = computeJoltage(bank, batteries)
            println("Joltage for $bank is $joltage")
            totalJoltage += joltage
        }
        return totalJoltage
    }

    private fun computeJoltage(bank: String, batteries: Int): Long {
        val joltageDigits = MutableList(batteries) { '0' }

        for (i in 0..<bank.length) {
            val current = bank[i]

            for (j in joltageStartIdx(i, bank.length, batteries)..<batteries) {
                if (joltageDigits[j] < current) {
                    joltageDigits[j] = current
                    resetJoltageCountersFrom(joltageDigits, j + 1)
                    break
                }
            }
        }
        return joltageDigits.joinToString("").toLong()
    }

    private fun joltageStartIdx(idx: Int, bankLength: Int, batteries: Int): Int {
        return maxOf(0, idx - bankLength + batteries)
    }

    private fun resetJoltageCountersFrom(joltage: MutableList<Char>, idx: Int) {
        for (i in idx..<joltage.size) {
            joltage[i] = '0'
        }
    }
}