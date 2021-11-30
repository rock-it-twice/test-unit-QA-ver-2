package fortestunit

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class BlogPage(val driver: WebDriver) {

    fun findEntry(entry: List<String>): String {
        val title = driver.findElement( By.xpath("//a[text()='${entry[0]}']") ).text
        return title
        }
    }