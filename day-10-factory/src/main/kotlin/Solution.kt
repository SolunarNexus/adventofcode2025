package org.example

import java.io.File
import kotlin.math.pow

private data class Schematic(val lights: Int, val buttons: List<Int>, val joltage: List<Int>) {

    companion object {
        fun of(input: String): Schematic =
            Schematic(
                lights = input.lightsToInt(),
                buttons = input
                    .substringAfter(" ")
                    .substringBefore(" {")
                    .split(" ")
                    .map { it.buttonsToInt() },
                joltage = input.substringAfter("{")
                    .substringBefore("}")
                    .split(",")
                    .map { it.toInt() }
            )

        private fun String.lightsToInt(): Int =
            this.substringAfter("[").substringBefore("]").reversed()
                .fold(0) { carry, next ->
                    (carry shl 1) or if (next == '#') 1 else 0
                }

        private fun String.buttonsToInt(): Int =
            this.substringAfter("(").substringBefore(")")
                .split(",")
                .fold(0) { carry, next ->
                    carry or (2 pow next.toInt())

                }

        infix fun Int.pow(exp: Int): Int =
            this.toDouble().pow(exp.toDouble()).toInt()

    }
}

class Solution {
    private val schematics: List<Schematic>

    constructor(inputPath: String) {
        schematics = File(inputPath).inputStream().bufferedReader().readLines()
            .map { Schematic.of(it) }
    }

    fun sumOfButtonPresses(): Int = schematics.sumOf { minimalButtonPresses(it) }

    private fun minimalButtonPresses(schematic: Schematic): Int =
        schematic.buttons
            .combinations()
            .sortedBy { it.size }
            .first { set ->
                set.fold(0) { c, n -> c xor n } == schematic.lights
            }.size

    private fun <T> List<T>.combinations(): List<Set<T>> =
        if (isEmpty()) listOf(emptySet())
        else drop(1).combinations().let { powerSetRest ->
            powerSetRest + powerSetRest.map { it + first() }
        }
}