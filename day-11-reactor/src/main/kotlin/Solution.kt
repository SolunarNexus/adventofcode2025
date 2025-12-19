package org.example

import java.io.File

class Solution {

    constructor(inputPath: String) {
        val lines = File(inputPath).inputStream().bufferedReader().readLines()
    }

}