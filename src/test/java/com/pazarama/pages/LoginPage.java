package com.pazarama.pages;

import com.pazarama.utilities.BrowserUtils;
import com.pazarama.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Username")
    public WebElement emailInputBox;
    @FindBy(id = "Password")
    public WebElement passwordInputBox;
    @FindBy(id = "submit-button")
    public WebElement submitButton;

    public void loginWithValidCredential() {
        // configration.properties dosyasından e-mail ve şifre bilgileri alınıp input alanlarına giriliyor. Submit butonuna tıklanıyor.
        emailInputBox.sendKeys(ConfigurationReader.getProperty("email"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        submitButton.click();

    }

}
