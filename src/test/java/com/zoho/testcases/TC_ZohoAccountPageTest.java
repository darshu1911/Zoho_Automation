package com.zoho.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoho.pageobjects.indexPage;
import com.zoho.pageobjects.otpVerify;
import com.zoho.pageobjects.zohoAccount;

public class TC_ZohoAccountPageTest extends BaseClass {
	
	@Test
	public void verifyRegistrationAndLogin() throws IOException, InterruptedException
	{
	
		indexPage pg = new indexPage(driver);
		pg.clickSignUp();
		
		zohoAccount zapg = new zohoAccount(driver);
		
		zapg.enterEmailId("darsh8@gmail.com");
		logger.info("Emailid entered in registration section");
		
		zapg.enterPassword("Darsh@142");
		logger.info("Password entered in registration section");
		
		zapg.enterMobileNo("9897863228");
		logger.info("MobileNO entered in registration section");
		
		zapg.selectCheckbox();
		logger.info("CheckBox marked in registration section");
		
		zapg.clickSignUpBtn();
		logger.info("Clicked on SignUp button");
		
		Thread.sleep(15000);
		
		zapg.clickSignUpBtn();
		logger.info("Clicked on SignUp button");
		
		otpVerify otppg = new otpVerify(driver);
		otppg.enterOtp("123456");
		logger.info("OTP entered in otp verify section");

		otppg.clickOnVerifyBtn();
		logger.info("Clicked on Verify button");
		
		String errorTxt = otppg.getVerifyError();
		System.out.println(errorTxt);
		
		if(errorTxt.equals("Please enter a valid "))
		{
			logger.info("Registration is Successfull");
			Assert.assertTrue(true);
		}else
		{
			logger.info("Registration is Failed");
			captureScreenshot(driver, "verifyRegistration");
			Assert.assertTrue(false);
		}
		

	}
}