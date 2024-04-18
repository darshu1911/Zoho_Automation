package com.zoho.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoho.pageobjects.loginPage;
import com.zoho.utilities.ReadXLSData;

public class TC_LoginPageTestData extends BaseClass {

    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "bvData")
    public void verifyLogin(String emailID, String password, String expectedUsername) throws IOException {
        loginPage lpg = new loginPage(driver);
        lpg.clickSignIn();
        logger.info("Sign in Link clicked successfully");

        WebElement emailField = waitForElementToBeClickable(By.id("emailId"), 10);
        emailField.sendKeys(emailID);
        logger.info("Email id entered successfully");

        lpg.clickNextBtn();
        logger.info("Next button clicked successfully");

        WebElement passwordField = waitForElementToBeClickable(By.id("password"), 10);
        passwordField.sendKeys(password);
        logger.info("Password entered successfully");

        lpg.clickSignInBtn();
        logger.info("Login button clicked successfully");

        WebElement productText = waitForElementToBeVisible(By.id("productText"), 10);
        String text = productText.getText();
        System.out.println(text);

        Assert.assertEquals(text, expectedUsername, "Expected username does not match actual username");
        logger.info("verifyLogin - Passed");
    }

    // Custom method to wait for an element to be clickable
    public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Custom method to wait for an element to be visible
    public WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
