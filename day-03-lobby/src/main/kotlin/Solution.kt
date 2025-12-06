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

    fun totalJoltage(): Long {
        val inputPath: String = if (isTest) testInputPath else inputPath
        val banks = File(inputPath).inputStream().bufferedReader().readLines()
        var totalJoltage = 0L

        for (bank: String in banks) {
            val it = bank.drop(1).iterator()
            var firstBattery = bank.first()
            var secondBattery = '0'

            while (it.hasNext()) {
                val current = it.next()

                if (it.hasNext() && current > firstBattery) {
                    firstBattery = current
                    secondBattery = '0'
                } else if (current > secondBattery) {
                    secondBattery = current
                }
            }

            val joltage: Int = String(charArrayOf(firstBattery, secondBattery)).toInt()
            println("Joltage for $bank is $joltage")
            totalJoltage += joltage
        }

        return totalJoltage
    }
}