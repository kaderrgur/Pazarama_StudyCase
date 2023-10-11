package com.pazarama.pages;

import com.pazarama.utilities.BrowserUtils;
import com.pazarama.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(css = "iframe:nth-child(1)")
    public WebElement advertisementIframe;
    @FindBy(css = "div.closeBtn")
    public WebElement closeIframeButton;

    @FindBy(tagName = "iframe")
    public List<WebElement> listOfIframes;

    @FindBy(css = ".product-filter-sidebar h1")
    public WebElement subCategoryName;

    @FindBy(xpath = "//p[contains(@class,'text-xxs')]")
    public static WebElement itemCountSubCategory;

    @FindBy(css = ".product-card")
    public List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@class='!w-1/4 px-2.5 py-2.5']//span[@name='heart']")
    public List<WebElement> likeButtonsOfProducts;

    // //div[@class='flex-1 pl-6.25 mb-9']//span[@name='heart']
    // css = ".product-card span g"

    @FindBy(css = ".line-clamp-2")
    public List<WebElement> listOfProductsNames;

    public void closeAdvertisementPopup() {
        if (listOfIframes.size() > 1) {
            Driver.getDriver().switchTo().frame(advertisementIframe);
            closeIframeButton.click();

        }
    }


    public Integer getItemCountSubCategory() {
        String textOfItemCount = itemCountSubCategory.getText().trim().replace(".", "");
        return Integer.parseInt(textOfItemCount.substring(0, textOfItemCount.indexOf(" ")));
    }

}
