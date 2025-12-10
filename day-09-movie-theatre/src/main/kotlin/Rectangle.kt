package org.example

import kotlin.math.max
import kotlin.math.min

class Rectangle(val x: IntRange, val y: IntRange) {

    val area: Long = x.size().toLong() * y.size()

    fun inner(): Rectangle = Rectangle(x.first + 1..<x.last, y.first + 1..<y.last)

    fun overlaps(other: Rectangle): Boolean = x.overlaps(other.x) && y.overlaps(other.y)

    companion object {
        fun of(a: Point2D, b: Point2D): Rectangle = Rectangle(
            min(a.x, b.x)..max(a.x, b.x),
            min(a.y, b.y)..max(a.y, b.y),
        )
    }

    fun IntRange.overlaps(other: IntRange): Boolean = max(first, other.first) <= min(last, other.last)

    fun IntRange.size(): Int = last - first + 1
}