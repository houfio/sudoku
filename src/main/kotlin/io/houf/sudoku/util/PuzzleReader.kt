package io.houf.sudoku.util

import io.houf.sudoku.model.puzzle.PuzzleCandidate
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.extension
import kotlin.io.path.isDirectory
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.readText
import kotlin.streams.toList

object PuzzleReader {
    fun readPuzzles(): List<PuzzleCandidate> {
        val uri = this::class.java.getResource("/puzzles")?.toURI() ?: return emptyList()

        val path = if (uri.scheme.equals("jar")) {
            FileSystems.newFileSystem(uri, emptyMap<String, Any>()).getPath("/puzzles")
        } else {
            Paths.get(uri)
        }

        return Files.walk(path, 1).filter { !it.isDirectory() }.map {
            PuzzleCandidate(
                it.nameWithoutExtension,
                it.extension,
                it.readText()
            )
        }.toList()
    }
}
