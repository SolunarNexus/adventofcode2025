package org.example

import java.io.File

typealias Coordinate = Pair<Int, Int>

class Solution {
    val input: List<String>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }

    fun coordinates(): List<Coordinate> = input.map { line ->
        val (x, y) = line.split(',').map { it.toInt() }
        Pair(x, y)
    }

    fun possibleCorners(coordinates: List<Coordinate>): List<Coordinate> {
        return emptyList()
    }
}