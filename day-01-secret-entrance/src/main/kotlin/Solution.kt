package org.example

import java.io.File
import java.io.InputStream
import java.util.*

class Solution {
    var inputPath = "day-01-secret-entrance/src/main/resources/input.txt"

    fun simplePassword(dial: Int = 50, range: Int = 100): Int {
        var password = 0
        var dial = dial
        val inputStream: InputStream = File(inputPath).inputStream()
        println("The dial starts by pointing at $dial")

        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                val rotation = parseRotation(it)
                dial = moveDial(dial, rotation, range)
                if (dial == 0) password++

                println("The dial is rotated $it to point at $dial")
            }
        }
        return password
    }

    fun advancedPassword(dial: Int = 50, range: Int = 100): Int {
        var password = 0
        var dial = dial
        val inputStream: InputStream = File(inputPath).inputStream()
        println("The dial starts by pointing at $dial")

        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                val rotation = parseRotation(it)
                password += computePassesByZero(rotation, dial, range)
                dial = moveDial(dial, rotation, range)

                println("The dial is rotated $it to point at $dial")
            }
        }
        return password
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
