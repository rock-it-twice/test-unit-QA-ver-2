package fortestunit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class AddEntryPage(val driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    // Инициализация заголовка
    @FindBy(css = "div#content h1")
    var title: WebElement? = null
    // Инициализация полей
    @FindBy(css = "[id='id_title']")
    var titleField: WebElement? = null

    @FindBy(css = "[id='id_slug']")
    var slugField: WebElement? = null

    @FindBy(css = "[id='id_text_markdown']")
    var textMarkdownField: WebElement? = null

    @FindBy(css = "[id='id_text']")
    var textField: WebElement? = null

    // Инициализация кнопки "Сохранить"
    @FindBy(css = "[name='_save']")
    var saveButton: WebElement? = null

    // Заполнение полей
    fun typeTitle(title: String) {
        titleField!!.sendKeys(title)
    }
    fun typeSlug(slug: String) {
        slugField!!.sendKeys(slug)
    }
    fun typeTextMarkDown(textMarkdown: String) {
        textMarkdownField!!.sendKeys(textMarkdown)
    }
    fun typeText(text: String) {
        textField!!.sendKeys(text)
    }

    // Нажатие кнопки "Сохранить"
    fun clickSaveButton() {
        return saveButton!!.click()
    }

    // Создание записи и дальнейшее её сохранение
    fun makeEntry(entry: List<String>) {
        typeTitle(entry[0])
        typeSlug(entry[1])
        typeTextMarkDown(entry[2])
        typeText(entry[3])
        clickSaveButton()
    }
}