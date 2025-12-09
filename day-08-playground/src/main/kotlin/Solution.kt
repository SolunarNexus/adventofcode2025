package org.example

import java.io.File
import kotlin.collections.List
import kotlin.collections.plus
import kotlin.math.pow
import kotlin.math.sqrt

typealias Coordinate = Triple<Int, Int, Int>
typealias Connection = Pair<Coordinate, Coordinate>
typealias Circuit = List<Coordinate>

class Solution {
    val input: List<String>

    constructor(inputPath: String) {
        this.input = File(inputPath).inputStream().bufferedReader().readLines()
    }

    fun circuits(connectionsAvailable: Int = 10) = computeCircuits(coordinates(), connectionsAvailable)

    private fun allConnections(coordinates: List<Coordinate>): List<Connection> =
        coordinates.flatMapIndexed { i, coord ->
            coordinates.drop(i + 1).map { other -> Pair(coord, other) }
        }

    private fun coordinates(): List<Coordinate> = input.map { line ->
        val (x, y, z) = line.split(',').map { it.toInt() }
        Triple(x, y, z)
    }

    private fun distance(connection: Connection): Double {
        val (a, b, c) = connection.first
        val (x, y, z) = connection.second
        return sqrt((a - x.toDouble()).pow(2) + (b - y.toDouble()).pow(2) + (c - z.toDouble()).pow(2))
    }

    private fun computeDistances(connections: List<Connection>): List<Pair<Connection, Double>> =
        connections.map { Pair(it, distance(it)) }

    private fun insertIntoCircuit(connection: Connection, circuits: MutableList<Circuit>) {
        val (posA, posB) = connection

        if (circuits.any { it.contains(posA) && it.contains(posB) }) {
            return
        } else if (circuits.any { it.contains(posA) } && circuits.none { it.contains(posB) }) {
            val target = circuits.indexOfFirst { it.contains(posA) }
            circuits[target] += posB
        } else if (circuits.any { it.contains(posB) } && circuits.none { it.contains(posA) }) {
            val target = circuits.indexOfFirst { it.contains(posB) }
            circuits[target] += posA
        } else {
            val circuitA = circuits.indexOfFirst { it.contains(posA) }
            val circuitB = circuits.indexOfFirst { it.contains(posB) }
            circuits[circuitA] = circuits[circuitA] + circuits[circuitB]
            circuits.removeAt(circuitB)
        }
    }

    private fun computeCircuits(coordinates: List<Coordinate>, connectionsAvailable: Int): List<Circuit> {
        val distances = computeDistances(allConnections(coordinates)).sortedBy { it.second }
        val circuits = coordinates.map { listOf(it) }.toMutableList()

        for (connection in distances.map { it.first }.take(connectionsAvailable)) {
            insertIntoCircuit(connection, circuits)
        }

        return circuits
    }
}