package com.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class indexPage {

	//	create object of webdriver
	WebDriver ldriver;


	//constructor
	public indexPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify webelements

	@FindBy(linkText = "Sign up")
	WebElement signup;

	//identify action on webelement
	public void clickSignUp()
	{
		signup.click();
	}

}
