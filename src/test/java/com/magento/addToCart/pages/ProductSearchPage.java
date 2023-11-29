package com.magento.addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class ProductSearchPage {

    private static ProductSearchPage productSearchPage;

    //Elements
    private final By welcomeMessage = By.xpath("//div[.='Thank you for registering with Main Website Store.']");
    private final By productSearchField = By.xpath("//*[@id=\"search\"]");
    private final By searchResultMessage = By.cssSelector("[data-ui-id=\"page-title-wrapper\"]");
    private final By firstSearchItem = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]");

    //Constructor
    private ProductSearchPage() { }

    public static ProductSearchPage getInstance(){
        if (productSearchPage == null) {
            productSearchPage = new ProductSearchPage();
        }
        return productSearchPage;
    }

    public boolean isWelcomeMessageDisplayed(WebDriver driver) {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void inputProductSearchField(WebDriver driver) {
        driver.findElement(productSearchField).sendKeys("Backpack");
        driver.findElement(productSearchField).sendKeys(Keys.ENTER);
    }

    public String getSearchResultMessage(WebDriver driver) {
        return driver.findElement(searchResultMessage).getText();
    }

    public void clickOnFirstSearchItem(WebDriver driver) {
        driver.findElement(firstSearchItem).click();
    }

}
