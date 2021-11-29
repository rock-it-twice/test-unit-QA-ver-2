package org.example

import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy

class LoginPage {  val userNameField: By
    @FindBy(id = "id_username")
    userNameField
}