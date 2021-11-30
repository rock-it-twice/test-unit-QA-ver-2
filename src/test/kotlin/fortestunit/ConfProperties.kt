package fortestunit

import java.io.FileInputStream
import java.util.*

class ConfProperties(val fileInputStream: FileInputStream =
    FileInputStream("src\\test\\resources\\conf.properties"),
    val properties: Properties = Properties() ) {
    init {
        properties.load(fileInputStream)
    }

    fun getProperty(key: String): String { return properties.getProperty(key) }

}
