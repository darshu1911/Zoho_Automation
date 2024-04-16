package com.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	@FindBy(id = "login_id")
	WebElement emailIdTxt;
	
	@FindBy(id = "nextbtn")
	WebElement nextBtn;
	
	@FindBy(id = "password")
	WebElement passwordTxt;
	
	@FindBy(id = "nextbtn")
	WebElement signInBtn;
	
	@FindBy(linkText = "Customers")
	WebElement verifyProductTxt;
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	public void enterEmailId(String emailID)
	{
		emailIdTxt.sendKeys(emailID);
	}
	
	public void clickNextBtn()
	{
		nextBtn.click();
	}
	
	public void enterPassword(String password)
	{
		passwordTxt.sendKeys(password);
	}
	
	public void clickSignInBtn()
	{
		signInBtn.click();
	}
	
	public String getProductTxt()
	{
		String text = verifyProductTxt.getText();
		return text;
	}


}
