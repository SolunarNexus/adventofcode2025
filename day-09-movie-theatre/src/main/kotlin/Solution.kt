package org.example

import java.io.File

typealias Coordinate = Pair<Int, Int>

class Solution {
    val input: List<String>
    val coordinates: List<Point2D>
    val rectangles: List<Rectangle>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
        this.coordinates = input.map { Point2D.of(it) }
        this.rectangles = coordinates.flatMapIndexed { index, left ->
            coordinates.drop(index + 1).map { right ->
                Rectangle.of(left, right)
            }
        }.sortedByDescending { it.area }
    }

    fun largestRectangleArea(): Long = rectangles.first().area

    fun largestRectangleAreWithinBounds(): Long {
        val lines: List<Rectangle> = (coordinates + coordinates.first())
            .zipWithNext()
            .map { (left, right) -> Rectangle.of(left, right) }

        return rectangles.first { rectangle ->
            val inner = rectangle.inner()
            lines.none { line -> line.overlaps(inner) }
        }.area
    }
}