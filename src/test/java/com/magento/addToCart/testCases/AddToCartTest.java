package com.magento.addToCart.testCases;

import com.magento.addToCart.base.BaseTest;
import com.magento.addToCart.models.User;
import com.magento.addToCart.pages.ProductCartPage;
import com.magento.addToCart.pages.ProductSearchPage;
import com.magento.addToCart.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test(priority = 1)
    public void shouldBeAbleToSearchProduct() {

        User user = new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        ProductSearchPage.getInstance().inputProductSearchField(driver);
        String text = ProductSearchPage.getInstance().getSearchResultMessage(driver);
        Assert.assertEquals(text, "Search results for: 'Backpack'");
    }

    @Test(priority = 2)
    public void shouldBeAbleToSelectItem() {
        User user = new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        ProductSearchPage.getInstance().inputProductSearchField(driver);
        String text = ProductSearchPage.getInstance().getSearchResultMessage(driver);
        Assert.assertEquals(text, "Search results for: 'Backpack'");
        ProductSearchPage.getInstance().clickOnFirstSearchItem(driver);
    }

    @Test(priority = 3)
    public void shouldBeAbleToAddProductToCart() throws InterruptedException {
        User user = new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        ProductSearchPage.getInstance().inputProductSearchField(driver);
        String text = ProductSearchPage.getInstance().getSearchResultMessage(driver);
        Assert.assertEquals(text, "Search results for: 'Backpack'");
        ProductSearchPage.getInstance().clickOnFirstSearchItem(driver);
        ProductCartPage.getInstance().clickOnAddToCart(driver);
        Thread.sleep(5000);
        ProductCartPage.getInstance().clickOnCartIcon(driver);
        String latestItemName = ProductCartPage.getInstance().getTextFromLatestItem(driver);
        Assert.assertEquals(latestItemName, "Driven Backpack");
    }

}
