package org.example

import java.io.FileInputStream
import java.util.*

class ConfProperties(val fileInputStream: FileInputStream =
    FileInputStream("src\\test\\resources\\conf.properties"),
    val properties: Properties = Properties() ) {
    init {
        properties.load(fileInputStream)
    }

    fun getProperties(key: String): String { return properties.getProperty(key) }

}
