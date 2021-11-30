package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class EntryTablePage(val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    // Инициализация поля и кнопок необходимых для удаления записи
    @FindBy(xpath = "//select")
    var dropDownField: WebElement? = null
    @FindBy(css = "[value='delete_selected']")
    var deleteDrop: WebElement? = null
    @FindBy(css = "[title='Выполнить выбранное действие']")
    var doActionButton: WebElement? = null
    @FindBy(css = "[value='Да, я уверен']")
    var confirmActionButton: WebElement? = null

    // Удаление записи
    fun deleteEntry(entry: List<String>) {
        // Поскольку noteCheckBox ищется по имени созданной записи, путь инициализируется в функции
        val noteCheckBox =
            driver.findElement(By.xpath("//th[a[text() = '${entry[0]}']]/preceding-sibling::td"))
        noteCheckBox.click()
        dropDownField!!.click()
        deleteDrop!!.click()
        doActionButton!!.click()
        confirmActionButton!!.click()
    }


}