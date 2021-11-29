package org.example

import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class Test(val driver: WebDriver = ChromeDriver()) {

    val loginPage = LoginPage(driver)
    val controlPanel = ControlPanel(driver)
    val addEntryPage = AddEntryPage(driver)
    val blogPage = BlogPage(driver)
    val entryTablePage = EntryTablePage(driver)

    @BeforeClass
    fun setup(){
        // Определение пути и настройка драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties().getProperties("chromedriver"))
        // Развертывание окна на полный экран
        driver.manage().window().maximize()
        // Задержка на выполнение теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        // Получение адреса на страницу входа
        driver.get(ConfProperties().getProperties("loginPage"))
    }

    @Test
    fun loginTest(){

    }
}