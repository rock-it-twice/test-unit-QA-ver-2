package org.example

import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class Test() {
    var driver: WebDriver = ChromeDriver()
    val loginPage: LoginPage = LoginPage(driver)
    val controlPanel: ControlPanel = ControlPanel(driver)
    val addEntryPage: AddEntryPage = AddEntryPage(driver)
    val blogPage: BlogPage = BlogPage(driver)
    val entryTablePage: EntryTablePage = EntryTablePage(driver)

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            // Определение пути драйвера
            System.setProperty("webdriver.chrome.driver", ConfProperties().getProperty("chromedriver"))
        }
    }

    init {
        // Развертывание окна на полный экран
        driver.manage().window().maximize()
        // Задержка на выполнение теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        // Получение адреса на страницу входа
        driver.get(ConfProperties().getProperty("loginPageAddress"))
    }


    @Test
    fun myTest() {
        // Получение имени пользователя и пароля
        val username = ConfProperties().getProperty("username")
        val password = ConfProperties().getProperty("password")
        // Вход
        loginPage.loginAs(username, password)

        // Проверка, что на новой странице есть Заголовок "Панель управления"
        val exp = "Панель управления"
        val actual = controlPanel.title!!.text
        Assert.assertEquals(exp, actual)

        // Нажимает кнопку "+Добавить" в разделе Blog/Entries
        controlPanel.clickAddEntriesButton()

        // Проверка, что на новой странице есть заголовок "Добавить entry"
        val exp2 = "Добавить entry"
        val actual2 = addEntryPage.title!!.text
        Assert.assertEquals(exp2, actual2)

        // Заполнение полей и создание записи
        val randomNumber = (0..9999999999).random().toString()
        val myEntry = listOf("title", "slug", "textMarkdown", "text")
        myEntry.forEach { it + randomNumber }
        addEntryPage.makeEntry(myEntry)

        // Проверка, что запись появилась на сайте
        blogPage.driver.get(ConfProperties().getProperty("blogAddress"))
        val actual3 = blogPage.findEntry(myEntry)
        Assert.assertEquals(myEntry[0], actual3)
        blogPage.driver.close()

        // Удаляет запись
        entryTablePage.deleteEntry(myEntry)
    }
}