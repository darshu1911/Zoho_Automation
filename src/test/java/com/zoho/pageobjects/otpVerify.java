package com.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class otpVerify {

	WebDriver ldriver;

	public otpVerify(WebDriver rdriver) 
	{
		//	create object of webdriver
		ldriver = rdriver;

		//constructor
		PageFactory.initElements(rdriver, this);
	}

	//identify webelements
//	@FindBy(xpath = "//span[normalize-space()='Change']")
//	WebElement changeLink;

//	@FindBy(xpath = "//span[@class='resendotp']")
//	WebElement resendOtp;

	@FindBy(id = "otpfield")
	WebElement otpField;

	@FindBy(name = "otpfield")
	WebElement verifyBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter a valid OTP']")
	WebElement verifyError;

	

//	public void clickOnChangeLink()
//	{
//		changeLink.click();;
//	}
//	
//	public void clickOnResendOtpLink()
//	{
//		resendOtp.click();;
//	}
	
	public void enterOtp(String OTP)
	{
		otpField.sendKeys(OTP);
	}
	
	public void clickOnVerifyBtn()
	{
		verifyBtn.click();
	}
	
	public String getVerifyError()
	{
		String text = verifyError.getText();
		return text;
	}

}
