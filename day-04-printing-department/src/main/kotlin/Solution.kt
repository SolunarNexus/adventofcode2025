package org.example

import java.io.File

class Solution {
    val inputPath: String

    constructor(inputPath: String) {
        this.inputPath = inputPath
    }

    // Represents the vector that points to the direction
    enum class Direction(val row: Int, val col: Int) {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1),
        DIAGONAL_LEFT_UP(-1, -1),
        DIAGONAL_RIGHT_UP(1, -1),
        DIAGONAL_LEFT_DOWN(-1, 1),
        DIAGONAL_RIGHT_DOWN(1, 1)
    }

    fun allRemovableRolls(): Int {
        val grid = File(inputPath).inputStream().bufferedReader().readLines().toMutableList()
        var removableRolls = 0

        do {
            val accessibleRollsCount = removeAccessibleRolls(grid)
            removableRolls += accessibleRollsCount
        } while (accessibleRollsCount > 0)

        println("Grid after removing all possible rolls:")
        grid.forEach { println(it) }
        return removableRolls
    }

    private fun removeAccessibleRolls(grid: MutableList<String>): Int {
        var removableRolls = 0

        for (row in 0..<grid.size) {
            for (col in 0..<grid[row].length) {
                if (isAccessibleRollCell(grid, row, col)) {
                    removableRolls++
                    grid[row] = grid[row].replaceRange(col, col + 1, ".")
                }
            }
        }
        return removableRolls
    }

    fun accessibleRolls(): Int {
        val grid = File(inputPath).inputStream().bufferedReader().readLines().toList()
        var accessibleRollsCount = 0

        for (row in 0..<grid.size) {
            for (col in 0..<grid[row].length) {
                if (isAccessibleRollCell(grid, row, col)) {
                    accessibleRollsCount++
                }
            }
        }

        return accessibleRollsCount
    }

    private fun isAccessibleRollCell(grid: List<String>, row: Int, col: Int): Boolean {
        if (!isRollCell(grid, row, col)) return false
        var rollsInProximity = 0

        for (direction in Direction.entries) {
            val nextRow = row + direction.row
            val nextCol = col + direction.col

            if (nextRow in grid.indices && nextCol in grid[nextRow].indices && isRollCell(grid, nextRow, nextCol)) {
                rollsInProximity++
            }

            if (rollsInProximity >= 4) return false
        }

        return true
    }

    private fun isRollCell(grid: List<String>, row: Int, col: Int): Boolean = grid[row][col] == '@'
}