package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class BlogPage(val driver: WebDriver) {

    fun findEntry(note: List<String>): String {
        val title = driver.findElement( By.xpath("//a[text()='${note[0]}']") ).text
        return title
        }
    }