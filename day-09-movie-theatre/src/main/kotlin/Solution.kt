package org.example

import java.io.File
import kotlin.math.abs

typealias Coordinate = Pair<Int, Int>

class Solution {
    val input: List<String>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }

    fun largestRectangleArea(): Long = coordinates().pairs().maxOfOrNull { rectangleArea(it) } ?: 0

    private fun coordinates(): List<Coordinate> = input.map { line ->
        val (x, y) = line.split(',').map { it.toInt() }
        Pair(x, y)
    }

    private fun List<Coordinate>.pairs(): List<Pair<Coordinate, Coordinate>> =
        this.flatMapIndexed { i, coord ->
            this.drop(i + 1).map { other -> Pair(coord, other) }
        }

    private fun rectangleArea(oppositeCorners: Pair<Coordinate, Coordinate>): Long {
        val cornerA = oppositeCorners.first
        val cornerB = oppositeCorners.second
        return abs(cornerA.first - cornerB.first).plus(1) * abs(cornerA.second - cornerB.second).plus(1).toLong()
    }
}