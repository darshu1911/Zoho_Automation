package com.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {
	
//	create object of webdriver
	WebDriver ldriver;


	//constructor
	public registeredUserAccount(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify webelements

	@FindBy(xpath = "//body/header/div[@class='zw-global-header']/div[@class='header uheader']/div[@id='header']/div[@class='zgh-utilities']/div[@class='zgh-accounts']/div[@class='zgh-user-box']/div[@class='zgh-userPanel']/img[1]")
	WebElement myAccountimg;
	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	WebElement userName;
	
	@FindBy(linkText = "My Account")
	WebElement myAccountLink;
	
	@FindBy(xpath = "//div[@class='zgh-userPanel active']//a[contains(text(),'Sign Out')]")
	WebElement signOutLink;

	//identify action on webelement
	public void clickMyAccountimg()
	{
		myAccountimg.click();
	}
	
	public String getUserName()
	{
		String text = userName.getText();
		return text;
	}
	
	public void clickmyAccountLink() 
	{
		myAccountLink.click();
	}
	
	public void clicksignOutLink() 
	{
		signOutLink.click();
	}
	

}
