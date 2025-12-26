package org.example

import java.io.File

class Solution {
    private val presents: List<Int>
    private val treeRegions: List<TreeRegion>

    constructor(inputPath: String) {
        val input = File(inputPath).inputStream().bufferedReader().readText()
        this.presents = input.split("\n\n").dropLast(1).map { present -> present.count { it == '#' } }
        this.treeRegions = input.split("\n\n").last().lines().map { TreeRegion.of(it) }
    }

    fun fittingRegions(): Int =
        treeRegions.count { region ->
            region.counts.zip(presents).sumOf { (count, present) ->
                count * present
            } <= region.area
        }

    private data class TreeRegion(val area: Int, val counts: List<Int>) {

        companion object {
            fun of(input: String): TreeRegion =
                TreeRegion(
                    input.substringBefore("x").toInt() *
                            input.substringAfter("x").substringBefore(":").toInt(),
                    input.substringAfter(" ").split(" ").map { it.toInt() }
                )
        }
    }
}