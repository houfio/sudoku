package io.houf.sudoku.util

import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.nio.file.*
import kotlin.io.path.extension
import kotlin.io.path.isDirectory
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.readText


object PuzzleReader {
    
    fun readPuzzles(): List<Triple<String, String, String?>> {
        val uri: URI = this::class.java.getResource("/puzzles").toURI()
        val myPath: Path
        val list = mutableListOf<Triple<String,String,String?>>()
        if (uri.getScheme().equals("jar")) {
            val fileSystem: FileSystem = FileSystems.newFileSystem(uri, emptyMap<String, Any>())
            myPath = fileSystem.getPath("/resources")
        } else {
            myPath = Paths.get(uri)
        }
        val walk = Files.walk(myPath, 1)
        val it = walk.iterator()
        while (it.hasNext()) {
            val file = it.next()
            if (!file.isDirectory())
                list.add(
                    Triple(file.nameWithoutExtension, file.extension, file.readText()))
        }
        return list
    }
}
