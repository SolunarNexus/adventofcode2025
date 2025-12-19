package org.example

import java.io.File
import java.util.LinkedList
import java.util.Queue

class Solution {
    private val graph: Map<String, List<String>>

    constructor(inputPath: String) {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
        this.graph = lines.map { it.split(":") }.associate { it[0] to it[1].split(" ").map { part -> part.trim()} }
    }

    fun paths(start: String): Int {
        val queue: Queue<String> = LinkedList(listOf(start))
        var paths = 0

        while(queue.isNotEmpty()){
            val current = queue.poll()
            if(current == "out"){
                paths++
            }
            graph[current]?.forEach { queue.add(it) }
        }
        return paths
    }
}