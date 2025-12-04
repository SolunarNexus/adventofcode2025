package org.example

import java.io.File

class Solution {
    var inputPath = "day-02-gift-shop/src/main/resources/input.txt"

    fun idsOfTwoEqualSequences(): Sequence<Long> {
        var ids = sequenceOf<Long>()
        val ranges = File(inputPath).inputStream().bufferedReader().readLine().split(',')

        for (range: String in ranges) {
            val start = range.substringBefore('-').toLong()
            val end = range.substringAfter('-').toLong()

            for (id: Long in start..end) {
                val idValue = id.toString()
                val idLength = idValue.length

                if (idLength % 2 == 0 && idValue.take(idLength / 2) == idValue.substring(idLength / 2)) {
                    ids += id
                }
            }
        }
        return ids
    }

    fun idsOfMultipleEqualSequences(): Sequence<Long> {
        var ids = sequenceOf<Long>()
        val ranges = File(inputPath).inputStream().bufferedReader().readLine().split(',')

        for (range: String in ranges) {
            val start = range.substringBefore('-').toLong()
            val end = range.substringAfter('-').toLong()

            for (id: Long in start..end) {
                val idSeq = id.toString()
                val mid = id.toString().length / 2

                for (offset in (1..mid).filter { idSeq.length % it == 0 }) {
                    if (containsEqualSequences(idSeq, offset)) {
                        ids += id
                        break
                    }
                }
            }
        }
        return ids
    }

    fun containsEqualSequences(id: String, offset: Int): Boolean {
        var seqStart = 0

        while (seqStart + 2 * offset - 1 < id.length) {
            val currentSeq = id.slice(seqStart..< seqStart + offset)
            val nextSeq = id.slice(seqStart + offset..< seqStart + 2 * offset)

            if (currentSeq != nextSeq) {
                return false
            } else {
                seqStart += offset
            }
        }

        return true
    }

    fun sumOfInvalidIDs(): Long = idsOfMultipleEqualSequences().sum()
}