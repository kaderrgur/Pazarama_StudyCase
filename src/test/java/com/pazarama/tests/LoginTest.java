package com.pazarama.tests;

import com.pazarama.pages.Homepage;
import com.pazarama.pages.Log;
import com.pazarama.pages.LoginPage;
import com.pazarama.utilities.BrowserUtils;
import com.pazarama.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.pazarama.pages.Log.logger;


public class LoginTest extends BaseTest {

    @Test(testName = "Login sayfasına gidilir ve doğru kullanıcı adı ve parola ile login olunabildiği doğrulanır.")
    public void testValidLogin() {

        Homepage homepage = new Homepage();
        LoginPage loginPage = new LoginPage();

        // Kullanıcı ana sayfaya gider
        homepage.goToHomepage();
        logger.info("Kullanıcı ana sayfaya gider");


        // Kullanıcı oturum açma butonuna tıklar
        homepage.loginOrSignInButton.click();

        // Kullanıcının e-mail ve şifresi input alanını girilir
        loginPage.loginWithValidCredential();

        // Kullanıcı ana sayfaya yönlendirir ve sayfada kullanıcının adını görür
        String userFullName = ConfigurationReader.getProperty("firstname") + " " + ConfigurationReader.getProperty("lastname");

        // Kullanıcı adını görüntüleyebilmek adına 5 sn bekleme verildi
        BrowserUtils.waitForVisibility(homepage.userFullName, 5);

        // Kullanıcının başarıyla oturum açtığını onaylanıypr
        Assert.assertEquals(homepage.userFullName.getText(), userFullName);

    }
}
