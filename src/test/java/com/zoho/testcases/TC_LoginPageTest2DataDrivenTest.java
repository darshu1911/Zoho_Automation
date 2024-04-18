package com.zoho.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.pageobjects.loginPage;
import com.zoho.utilities.ReadExcelFile;

public class TC_LoginPageTest2DataDrivenTest extends BaseClass {
    
    @Test(dataProvider = "LoginDataProvider")
    public void verifyLogin(String emailID, String password, String expectedUsername) throws IOException {
        loginPage lpg = new loginPage(driver);
        lpg.clickSignIn();
        logger.info("Sign in Link clicked successfully");

        lpg.enterEmailId(emailID);
        logger.info("Email id entered successfully");

        lpg.clickNextBtn();
        logger.info("Next button clicked successfully");

        lpg.enterPassword(password);
        logger.info("Password entered successfully");

        lpg.clickSignInBtn();
        logger.info("Login button clicked successfully");

        String text = lpg.getProductTxt();
        System.out.println(text);

        Assert.assertEquals(text, expectedUsername, "Expected username does not match actual username");
        logger.info("verifyLogin - Passed");
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] loginDataProvider() {
        String fileName = System.getProperty("user.dir") + "\\Test Data\\Test Data.xlsx";
        int totalRows = ReadExcelFile.getRowCount(fileName, "TC_LoginPageTestData");
        int totalColumns = ReadExcelFile.getColumnCount(fileName, "TC_LoginPageTestData");

        Object[][] data = new Object[totalRows - 1][totalColumns]; // Adjusted to skip header row

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "TC_LoginPageTestData", i, j);
            }
        }
        return data;
    }
}