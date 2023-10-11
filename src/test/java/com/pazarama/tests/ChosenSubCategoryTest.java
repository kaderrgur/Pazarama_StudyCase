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

public class ChosenSubCategoryTest extends BaseTest {

    @Test
    public void testChosenSubCategory() throws InterruptedException {
        Homepage homepage = new Homepage();
        CategoryPage categoryPage = new CategoryPage();
        MyFavoritesPage myFavoritesPage = new MyFavoritesPage();
        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();


        // Kullanıcı anasayfaya gider ve üye girişi yapar
        homepage.goToHomepage();
        homepage.loginOrSignInButton.click();
        loginPage.loginWithValidCredential();

        // Reklam ve bildirim pop upları kapatılır
        homepage.closeNotificationPopup();
        categoryPage.closeAdvertisementPopup();

        //Alt kategori seçimi için random sayı üretilir
        int randomCategoryNumber = faker.random().nextInt(homepage.listOfCategories.size());
        WebElement chosenCategory = homepage.listOfCategories.get(randomCategoryNumber);

        //Kullanıcı menüdeki rastgele kategorilerden birinin üzerine gelir
        BrowserUtils.hover(chosenCategory);

        // İlgili kategorinin görünür olması beklenir
        BrowserUtils.waitForVisibility(homepage.getListOfClickableSubcategories(randomCategoryNumber).get(0), 10);

        // Tıklanabilir alt kategorileri bir liste elementinde topladım
        List<WebElement> listOfClickableSubcategories = homepage.getListOfClickableSubcategories(randomCategoryNumber);

        // Tıklanabilir alt kategorilerin sayısına göre resgele bir sayı oluşturulur
        int randomSubcategoryNumber = faker.random().nextInt(listOfClickableSubcategories.size());

        // Seçilen alt kategorinin ismi yazdırılır ve tıklanır
        String chosenSubCategoryName = listOfClickableSubcategories.get(randomSubcategoryNumber).getText();
        System.out.println("Seçilen Alt kategori: " + chosenSubCategoryName);
        listOfClickableSubcategories.get(randomSubcategoryNumber).click();
        BrowserUtils.waitFor(5);


//        int randomItemNumber = (categoryPage.getItemCountSubCategory() > 80) ? faker.random().nextInt(80) : faker.random().nextInt(categoryPage.getItemCountSubCategory());
//        BrowserUtils.waitForClickablityThenClick(categoryPage.likeButtonsOfProducts.get(randomItemNumber), 10);
//        // Store the chosen item name for assertion
//        String expectedItemName = categoryPage.listOfProductsNames.get(randomItemNumber).getText().trim();
//        // User goes to my favorites page and asserts that the chosen item exists in my favorites page or not
//        homepage.myFavoritesButton.click();
//        BrowserUtils.waitFor(3);
//        String actualItemName = myFavoritesPage.listOfLikedProductsNames.get(0).getText().trim();
//        Assert.assertEquals(actualItemName, expectedItemName);



    }
}
