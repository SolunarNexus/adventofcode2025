package org.example

import java.io.File
import kotlin.text.lines

class Solution {
    val inputPath: String

    constructor(inputPath: String) {
        this.inputPath = inputPath
    }

    fun availableFreshIngredientsCount(): Int = availableFreshIngredientIds().size

    fun allFreshIngredientsIdsCount(): Long = allFreshIngredientIds().sumOf { it.last - it.first + 1 }

    private fun availableFreshIngredientIds(): List<Long> {
        val database = File(inputPath).inputStream().bufferedReader().readText().split("\n\n")
        val ranges = database[0].lines().map {
            Pair(it.substringBefore('-'), it.substringAfter('-'))
        }
        val available = database[1].lines().map { it.toLong() }
        val freshIds = mutableListOf<Long>()

        for (id in available) {
            if (ranges.any { (start, end) -> id in start.toLong()..end.toLong() }) {
                freshIds.add(id)
            }
        }

        println("Fresh ingredients IDs are: ${freshIds.joinToString(", ")}")
        return freshIds
    }

    private fun allFreshIngredientIds(): Set<LongRange> {
        val database = File(inputPath).inputStream().bufferedReader().readText().split("\n\n")
        val ranges = database[0].lines()
            .map { LongRange(it.substringBefore('-').toLong(), it.substringAfter('-').toLong()) }
            .sortedBy { longs -> longs.first }
        val merged = ranges.fold(mutableSetOf<LongRange>()) { seen, range -> range.mergeInto(seen) }

        println("All fresh ingredients ID ranges are: ${merged.joinToString(", ") { "(${it.first}-${it.last})"}}")
        return merged
    }

    private fun LongRange.mergeInto(seen: MutableSet<LongRange>): MutableSet<LongRange> = seen
        .filter { it overlaps this || it adjoint this }
        .toMutableSet()
        .let { toMerge ->
            if (toMerge.isEmpty()) seen.apply { add(this@mergeInto) }
            else seen.apply {
                toMerge.apply { add(this@mergeInto) }.merge()
                    .let { merged -> seen.apply { removeAll(toMerge); add(merged) } }
            }
        }

    /**
     * Returns true if this range overlaps with the other range.
     * @param other The other range to check.
     * @return True if the ranges overlap, false otherwise.
     */
    infix fun <T: Comparable<T>> ClosedRange<T>.overlaps(other: ClosedRange<T>): Boolean =
        this.start <= other.endInclusive && other.start <= this.endInclusive

    /**
     * Returns true if this range is adjacent to the other range.
     * @param other The other range to check.
     * @return True if the ranges are adjacent, false otherwise.
     */
    infix fun LongRange.adjoint(other: LongRange): Boolean = this.last + 1 == other.first || other.last + 1 == this.first

    /**
     * Merges a list of LongRanges into a single LongRange that spans from the minimum start to the maximum end.
     * @return A LongRange that covers all ranges in the list.
     */
    fun Collection<LongRange>.merge(): LongRange = this.minOf { r -> r.first }..this.maxOf { r -> r.last }
}