package org.example

import java.io.File

class Solution {
    val inputPath = "day-02-gift-shop/src/main/resources/input.txt"
    val testInputPath = "day-02-gift-shop/src/main/resources/test_input.txt"
    var isTest: Boolean

    constructor(test: Boolean = false) {
        if (test) println("### Initializing TEST solution ###") else println("### Initializing PROD solution ###")
        this.isTest = test
    }

    enum class Policy {
        TWO_PARTS, N_PARTS
    }

    fun invalidIds(policy: Policy): Sequence<Long> {
        val inputPath: String = if (isTest) testInputPath else inputPath
        val ids = arrayListOf<Long>()
        val ranges = File(inputPath).inputStream().bufferedReader().readLine().split(',')

        for (range: String in ranges) {
            val start = range.substringBefore('-').toLong()
            val end = range.substringAfter('-').toLong()

            for (id: Long in start..end) {
                when (policy) {
                    Policy.TWO_PARTS -> processTwoPartId(id, ids)
                    Policy.N_PARTS -> processNPartId(id, ids)
                }
            }
        }

        return ids.asSequence()
    }

    fun processTwoPartId(id: Long, ids: MutableList<Long>) {
        val idSeq = id.toString()
        if (idSeq.length % 2 == 0 && containsEqualSequences(idSeq, idSeq.length / 2)) {
            ids.add(id)
        }
    }

    fun processNPartId(id: Long, ids: MutableList<Long>) {
        val idSeq = id.toString()
        val idLength = idSeq.length
        val mid = idLength / 2

        for (offset in (1..mid).filter { idLength % it == 0 }) {
            if (containsEqualSequences(idSeq, offset)) {
                ids.add(id)
                break
            }
        }

    }

    fun containsEqualSequences(id: String, offset: Int): Boolean {
        if (offset == 0) return false
        var seqStart = 0

        while (seqStart + 2 * offset - 1 < id.length) {
            val currentSeq = id.slice(seqStart..<seqStart + offset)
            val nextSeq = id.slice(seqStart + offset..<seqStart + 2 * offset)

            if (currentSeq != nextSeq) {
                return false
            } else {
                seqStart += offset
            }
        }

        return true
    }

    fun sumOfTwoPartIds(): Long = invalidIds(Policy.TWO_PARTS).sum()

    fun sumOfMultiplePartIds(): Long = invalidIds(Policy.N_PARTS).sum()
}