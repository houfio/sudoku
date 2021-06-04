package io.houf.sudoku.util.widget

import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

object Images {
    private val images = mutableMapOf<String, BufferedImage>()

    fun read(image: String): BufferedImage {
        return if (images.containsKey(image)) {
            images[image]!!
        } else try {
            val loaded = ImageIO.read(this::class.java.getResourceAsStream("/images/$image.png"))
            images[image] = loaded
            loaded
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}
