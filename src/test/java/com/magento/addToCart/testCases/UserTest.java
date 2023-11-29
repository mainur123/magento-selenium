package com.magento.addToCart.testCases;

import com.magento.addToCart.models.User;
import com.magento.addToCart.base.BaseTest;
import com.magento.addToCart.pages.RegisterPage;
import com.magento.addToCart.pages.ProductSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToRegisterToTheApplication() {
        User user = new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver, user);
        boolean welcomeDisplayed = ProductSearchPage.getInstance().isWelcomeMessageDisplayed(driver);
        Assert.assertTrue(welcomeDisplayed);
    }

}
