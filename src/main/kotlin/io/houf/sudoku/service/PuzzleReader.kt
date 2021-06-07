package io.houf.sudoku.service

import io.houf.sudoku.model.puzzle.PuzzleCandidate

interface PuzzleReader {
    fun readPuzzles(): List<PuzzleCandidate>
}
