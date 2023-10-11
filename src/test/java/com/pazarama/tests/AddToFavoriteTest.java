package com.pazarama.tests;

import com.github.javafaker.Faker;
import com.pazarama.pages.CategoryPage;
import com.pazarama.pages.Homepage;
import com.pazarama.pages.LoginPage;
import com.pazarama.pages.MyFavoritesPage;
import com.pazarama.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AddToFavoriteTest extends BaseTest {


    @Test
    public void testAddToFavorite() {
        Homepage homepage = new Homepage();
        LoginPage loginPage = new LoginPage();
        CategoryPage categoryPage = new CategoryPage();
        MyFavoritesPage myFavoritesPage = new MyFavoritesPage();
        Faker faker = new Faker();

        // Kullanıcı anasayfaya gider ve üye girişi yapar
        homepage.goToHomepage();
        homepage.loginOrSignInButton.click();
        loginPage.loginWithValidCredential();

        int randomItemNumber = (categoryPage.getItemCountSubCategory() > 80) ? faker.random().nextInt(80) : faker.random().nextInt(categoryPage.getItemCountSubCategory());
        BrowserUtils.waitForClickablityThenClick(categoryPage.likeButtonsOfProducts.get(randomItemNumber), 10);
        // Seçilen ürünü tutuyoruz
        String expectedItemName = categoryPage.listOfProductsNames.get(randomItemNumber).getText().trim();
        // Favorilerim sayfasına giderek ürünü karşılaştırıyoruz
        homepage.myFavoritesButton.click();
        BrowserUtils.waitFor(3);
        String actualItemName = myFavoritesPage.listOfLikedProductsNames.get(0).getText().trim();
        Assert.assertEquals(actualItemName, expectedItemName);


    }
}