package org.example

data class Point2D(val x: Int, val y: Int) {

    operator fun minus(other: Point2D): Point2D = Point2D(x - other.x, y - other.y)

    operator fun plus(other: Point2D): Point2D = Point2D(x + other.x, y + other.y)

    companion object {
        fun of(input: String): Point2D = input.split(",").let {
            Point2D(it.first().toInt(), it.last().toInt())
        }
    }
}