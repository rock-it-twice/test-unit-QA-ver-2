package org.example

import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class Test() {
    val driver: WebDriver = ChromeDriver()
    val loginPage: LoginPage = LoginPage(driver)
    val controlPanel: ControlPanel = ControlPanel(driver)
    val addEntryPage: AddEntryPage = AddEntryPage(driver)
    val blogPage: BlogPage = BlogPage(driver)
    val entryTablePage: EntryTablePage = EntryTablePage(driver)

    init {
        fun setup(){
            // Определение пути и настройка драйвера
            System.setProperty("webdriver.chrome.driver", ConfProperties().getProperty("chromedriver"))
            // Развертывание окна на полный экран
            driver.manage().window().maximize()
            // Задержка на выполнение теста
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
            // Получение адреса на страницу входа
            driver.get(ConfProperties().getProperty("loginPageAddress"))
        }
    }

    @Test
    fun loginTest(){
        // Получение имени пользователя и пароля
        val username = ConfProperties().getProperty("username")
        val password = ConfProperties().getProperty("password")
        // Вход
        loginPage.loginAs(username, password)
    }
    @Test
    fun assertTitleTest(){
        // Проверка, что на новой странице есть Заголовок "Панель управления"
        val title1 = ConfProperties().getProperty("title1")
        Assert.assertEquals(controlPanel.title!!.text, title1)
    }
}