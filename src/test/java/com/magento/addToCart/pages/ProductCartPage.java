package com.magento.addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCartPage {
    private static ProductCartPage productCartPage;
    private final By addToCartButton = By.cssSelector("[title=\"Add to Cart\"]");
    private final By cartIcon = By.cssSelector("[class=\"action showcart\"]");
    private final By addedItemName = By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li[1]/div/div/strong");

    public static ProductCartPage getInstance(){
        if (productCartPage == null) {
            productCartPage = new ProductCartPage();
        }
        return productCartPage;
    }

    public void clickOnAddToCart(WebDriver driver) {
        driver.findElement(addToCartButton).click();
    }

    public void clickOnCartIcon(WebDriver driver){
        driver.findElement(cartIcon).click();
    }

    public String getTextFromLatestItem(WebDriver driver){
        return driver.findElement(addedItemName).getText();
    }

}
