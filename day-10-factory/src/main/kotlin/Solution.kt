package org.example

import java.io.File

typealias Coordinate = Pair<Int, Int>

class Solution {
    val input: List<String>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }
}