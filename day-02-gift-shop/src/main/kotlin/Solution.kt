package org.example

import java.io.File

class Solution {
    var inputPath = "day-02-gift-shop/src/main/resources/input.txt"

    fun invalidIDs(): Sequence<Long> {
        var invalidIDs = sequenceOf<Long>()
        val ranges = File(inputPath).inputStream().bufferedReader().readLine().split(',')

        for (range: String in ranges) {
            val start = range.substringBefore('-').toLong()
            val end = range.substringAfter('-').toLong()

            for (id: Long in start..end) {
                val id = id.toString()
                val idLength = id.length

                if (idLength % 2 == 0 && id.take(idLength / 2) == id.substring(idLength / 2)){
                    invalidIDs += id.toLong()
                }
            }
        }

        return invalidIDs
    }
}