package org.example

import java.io.File
import java.util.*

class Solution {
    var inputPath = "day-01-secret-entrance/src/main/resources/input.txt"

    fun computePasswords(dial: Int = 50, range: Int = 100): Pair<Int, Int> {
        var simplePassword = 0
        var advancePassword = 0
        var dial = dial
        File(inputPath).inputStream().bufferedReader().useLines { lines ->
            lines.forEach {
                val rotation = parseRotation(it)
                advancePassword += computePassesByZero(rotation, dial, range)
                dial = moveDial(dial, rotation, range)
                simplePassword += if (dial == 0) 1 else 0
            }
        }

        return Pair(simplePassword, advancePassword)
    }

    private fun moveDial(dial: Int, rotation: Int, range: Int): Int =
        dial.plus(rotation).mod(range)

    private fun computePassesByZero(rotation: Int, dial: Int, range: Int): Int =
        if (rotation > 0) {
            dial.plus(rotation).div(range) - dial.div(range)
        } else {
            dial.minus(1).floorDiv(range) - dial.minus(1).plus(rotation).floorDiv(range)
        }

    private fun parseRotation(string: String): Int =
        if (string.startsWith('L')) {
            -string.substring(1).toInt()
        } else if (string.startsWith('R')) {
            string.substring(1).toInt()
        } else {
            throw InputMismatchException("Invalid input: $string")
        }
}
