package org.example

import java.io.File

class Solution {
    private val factory: Factory

    constructor(inputPath: String) {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
        this.factory = Factory.parse(lines)
    }

    fun sumOfButtonPressesForLights(): Long = factory.minTotalButtonPresses()

    fun sumOfButtonPressesForJoltage(): Long = factory.minTotalJoltagePresses()
}