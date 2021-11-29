package org.example

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.math.BigInteger

class ControlPanel(val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(css = "div#content h1") // Поиск заголовка
    var title: WebElement? = null
    @FindBy(css = "href='/admin/blog/entry/add/'") // Поиск кнопки addEntries
    var addEntriesButton: WebElement? = null

    // Проверка заголовка на соответствие
    fun checkTitle(elementToCheck: String): Boolean {
        return title!!.text == elementToCheck
    }

    // Нажатие на addEntries
    fun clickAddEntriesButton() {
        addEntriesButton!!.click()
    }

}