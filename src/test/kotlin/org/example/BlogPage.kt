package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class BlogPage(val driver: WebDriver) {

    fun findNote(note: List<String>): Boolean {
        try {
            driver.findElement( By.xpath("//a[text()='${note[0]}']") )
            return true
        } catch (e: org.openqa.selenium.NoSuchElementException){
            return false
        } finally {
            driver.close()
        }
    }

}