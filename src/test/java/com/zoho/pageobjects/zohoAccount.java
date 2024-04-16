package com.zoho.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class zohoAccount {

	//	create object of webdriver
	WebDriver ldriver;


	//constructor
	public zohoAccount(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify webelements
	@FindBy(id = "email")
	WebElement emailTxt;

	@FindBy(id = "password")
	WebElement pwdTxt;

	@FindBy(id = "rmobile")
	WebElement mobileTxt;

	@FindBy(id =  "signup-termservice")
	WebElement checkBox;

	@FindBy(id =  "signupbtn")
	WebElement signUpBtn;

	//identify action on webelement
	public void enterEmailId(String EmailId) 
	{
		emailTxt.sendKeys(EmailId);
	}

	public void enterPassword(String Password) 
	{
		pwdTxt.sendKeys(Password);
	}

	public void enterMobileNo(String MobileNo) 
	{
		mobileTxt.sendKeys(MobileNo);
	}

	public void selectCheckbox() 
	{
		checkBox.click();
	}

	public void clickSignUpBtn() 
	{
		signUpBtn.click();
	}

}
