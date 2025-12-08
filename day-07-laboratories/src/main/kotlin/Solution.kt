package org.example

import java.io.File

class Solution {
    val input: List<String>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }

    fun beamSplitSum(): Int {
        val (startX, startY) = Pair(input[0].indexOf('S'), 1)
        val manifold = input.toMutableList()
        val result = propagateBeam(manifold, startX, startY)
        manifold.forEach { println(it) }
        return result
    }

    fun quantumBeamSplitSum(): Long {
        val (startX, startY) = Pair(input[0].indexOf('S'), 1)
        val cache: MutableMap<Pair<Int, Int>, Long> = mutableMapOf()
        val result = propagateQuantumBeam(input, cache, startX, startY)
        return result
    }

    private fun propagateBeam(manifold: MutableList<String>, x: Int, y: Int): Int {
        if (y >= manifold.size) return 0

        when (manifold[y][x]) {
            '|' -> return 0
            '.' -> {
                manifold[y] = manifold[y].withIndex().map { (idx, it) -> if (idx == x) '|' else it }.joinToString("")
                return propagateBeam(manifold, x, y + 1)
            }
            '^' -> return 1 + propagateBeam(manifold, x - 1, y) + propagateBeam(manifold, x + 1, y)
            else -> throw IllegalArgumentException("Invalid character: ${manifold[y][x]}")
        }
    }

    private fun propagateQuantumBeam(manifold: List<String>, cache: MutableMap<Pair<Int, Int>, Long>, x: Int, y: Int): Long {
        if (y >= manifold.size) return 1

        return when (manifold[y][x]) {
            '.' -> propagateQuantumBeam(manifold, cache, x, y + 1)
            '^' -> {
                val key = Pair(x, y)
                if (!cache.contains(key)){
                    cache[key] = propagateQuantumBeam(manifold, cache, x - 1, y) + propagateQuantumBeam(manifold, cache, x + 1, y)
                }
                cache[key]!!
            }
            else -> throw IllegalArgumentException("Invalid character: ${manifold[y][x]}")
        }
    }
}