package io.houf.sudoku.util

import java.io.*
import java.nio.charset.Charset

object PuzzleReader {

    val  filePaths = listOf("puzzle.4x4", "puzzle.6x6", "puzzle.9x9", "puzzle.jigsaw", "puzzle.samurai")

    fun read(): List<Triple<String, String, String>> {
        val puzzles = mutableListOf<Triple<String,String,String>>()
        filePaths.forEach(){
            val triple = Triple(it.substringBefore('.'), it.substringAfter('.'), readFileUsingGetResource(it))
           puzzles.add(triple)
        }

        return puzzles;
    }

    fun readFileUsingGetResource(fileName: String)
        = this::class.java.getResource("/puzzles/$fileName").readText(Charsets.UTF_8)
}
