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

            // If the number of batteries does not fit between the actual index and bank's end, process as many least significant digits as possible
            for (j in joltageStartIdx(i, bank.length, batteries)..<batteries) {
                if (joltageDigits[j] < current) {
                    joltageDigits[j] = current
                    // Reset all successors of the current digit
                    joltageDigits.subList(j + 1, joltageDigits.size).fill('0')
                    break
                }
            }
        }
        return joltageDigits.joinToString("").toLong()
    }

    private fun joltageStartIdx(idx: Int, bankLength: Int, batteries: Int): Int {
        return maxOf(0, idx - bankLength + batteries)
    }
}