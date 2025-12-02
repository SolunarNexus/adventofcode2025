package org.example

import java.io.File
import java.io.InputStream
import java.util.*

class Solution {
    var inputPath = "day-01-secret-entrance/src/main/resources/input.txt"

    fun password(): Int {
        var password = 0
        var dial = 50
        val range = 100
        val inputStream: InputStream = File(inputPath).inputStream()

        println("The dial starts by pointing at $dial")

        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                val rotation = if (it.startsWith('L')) {
                    -it.substring(1).toInt()
                } else if (it.startsWith('R')) {
                    it.substring(1).toInt()
                } else {
                    throw InputMismatchException("Invalid input: $it")
                }

                dial = dial.plus(rotation).mod(range)
                println("The dial is rotated $it to point at $dial")

                if (dial == 0) password++
            }
        }

        return password
    }
}