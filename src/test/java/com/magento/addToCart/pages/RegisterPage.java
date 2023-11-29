package com.magento.addToCart.pages;

import com.magento.addToCart.models.User;
import com.magento.addToCart.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private static RegisterPage registerPage;
    //Elements
    private final By firstNameInput = By.cssSelector("[id=\"firstname\"]");
    private final By lastNameInput = By.cssSelector("[id=\"lastname\"]");
    private final By emailInput = By.cssSelector("[id=\"email_address\"]");
    private final By passwordInput = By.cssSelector("[id=\"password\"]");
    private final By confirmPasswordInput = By.cssSelector("[id=\"password-confirmation\"]");
    private final By submitButton = By.cssSelector("[title=\"Create an Account\"]");

    //Constructor
    private RegisterPage() {}

    public static RegisterPage getInstance() {
        if(registerPage == null){
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    //Methods or, Steps

    public void load(WebDriver driver) {
        driver.get(ConfigUtils.getInstance().getBaseUrl() +"/customer/account/create/");
    }
    public void register(WebDriver driver, User user) {
        driver.findElement(firstNameInput).sendKeys(user.getFirstName());
        driver.findElement(lastNameInput).sendKeys(user.getLastName());
        driver.findElement(emailInput).sendKeys(user.getEmail());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordInput).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();
    }


}
