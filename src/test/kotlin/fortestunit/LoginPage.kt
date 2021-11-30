package fortestunit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginPage(val driver: WebDriver) {
    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(css = "[id='id_username']") // Поиск поля для ввода имени пользователя
    var userNameField: WebElement? = null
    @FindBy(css = "[id='id_password']") // Поиск поля для ввода пароля
    var passwordField: WebElement? = null
    @FindBy(css = "[type='submit']") // Поиск кнопки ввод
    var loginButton: WebElement? = null


    // ввод логина (!! - удостоверяется, что переменная не null)
    fun typeUsername(username: String) {
        return userNameField!!.sendKeys(username)
    }

    // ввод пароля
    fun typePassword(password: String) {
        return passwordField!!.sendKeys(password)
    }

    // Нажатие на "Вход"
    fun clickLoginButton(){
        loginButton!!.click()
    }

    // Объединение функций
    fun loginAs(username: String, password: String) {
        typeUsername(username)
        typePassword(password)
        return clickLoginButton()
    }
}