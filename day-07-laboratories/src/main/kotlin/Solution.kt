package org.example

import java.io.File

class Solution {
    val inputPath: String
    val input: List<String>

    constructor(inputPath: String) {
        this.inputPath = inputPath
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }
}