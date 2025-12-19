package org.example

import java.io.File

class Solution {
    private val graph: Map<String, List<String>>

    constructor(inputPath: String) {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
        this.graph = lines.map { it.split(": ") }.associate { it[0] to it[1].split(" ").map { part -> part.trim() } }
    }

    fun paths(): Long = dfs("you", "out")


    fun pathsWithRequiredDevices(): Long =
        (dfs("svr", "dac") * dfs("dac", "fft") * dfs("fft", "out")) +
                (dfs("svr", "fft") * dfs("fft", "dac") * dfs("dac", "out"))


    private fun dfs(source: String, target: String, memory: MutableMap<String, Long> = mutableMapOf()): Long =
        if (source == target) 1L
        else memory.getOrPut(source) {
            graph[source]?.sumOf { next ->
                dfs(next, target, memory)
            } ?: 0
        }
}