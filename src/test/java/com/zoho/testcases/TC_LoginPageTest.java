
package com.zoho.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoho.pageobjects.loginPage;
import com.zoho.pageobjects.productsDrpdwn;
import com.zoho.pageobjects.registeredUserAccount;

public class TC_LoginPageTest extends BaseClass{
	
	
	@Test(enabled = true)
	public void verifyLogin() throws IOException
	{

		loginPage lpg = new loginPage(driver);
		lpg.clickSignIn();
		logger.info("Sigin in Link clicked succesfully");
		
		lpg.enterEmailId("dasdeepika758@gmail.com");
		logger.info("Email id entered succesfully");
		
		lpg.clickNextBtn();
		logger.info("Next button clicked succesfully");
		
		lpg.enterPassword("DasDeep@007");
		logger.info("Password entered succesfully");

		lpg.clickSignInBtn();
		logger.info("Login in button clicked succesfully");
		
		String Text = lpg.getProductTxt();
		System.out.println(Text);
		
		if (Text.equals("Customers")) 
		{
			logger.info("verifyLogin - Passed");
			Assert.assertTrue(true);
		}else
		{
			logger.info("verifyLogin - failed");
			captureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}

	}
	
	@Test(enabled = true)
	public void verifyProdPage() throws IOException {
		
			productsDrpdwn prodDP = new productsDrpdwn(driver);
			prodDP.clickProdDrpDwn();
			logger.info("Drop down clicked succesfully");
			
			prodDP.clickMrktLink();
			logger.info("Market link clicked succesfully");
			
			prodDP.clickSitesBtn();
			logger.info("Form button clicked succesfully");
			
			String prodTxt = prodDP.getZohoSitesTxt();
			System.out.println(prodTxt);
			
			if(prodTxt.equals("ACCESS ZOHO SITES"))
			{
				logger.info("verifyProdPage - passed");
				Assert.assertTrue(true);
			}else
			{
				logger.info("verifyProdPage - failed");
				captureScreenshot(driver, "verifyUser");
				Assert.assertTrue(false);
			}
	}
	
	@Test(enabled = true )
	public void verifyUser() throws IOException {
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		regUser.clickMyAccountimg();
		logger.info("Clicked on MyAccount Image");

		String userName = regUser.getUserName();
		System.out.println(userName);
		
		if(userName.equals("Dadeepika758"))
		{
			logger.info("verifyUser - passed");
			Assert.assertTrue(true);
			
			regUser.clicksignOutLink();
			logger.info("Sign out successfully");
		}else
		{
			logger.info("verifyUser - failed");
			captureScreenshot(driver, "verifyUser");
			Assert.assertTrue(false);
		}
	}
}
