package com.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsDrpdwn {

	WebDriver  ldriver;

	public productsDrpdwn(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//span[@class='pd-dp'])[1]")
	WebElement prodDrpdwn;

	@FindBy(xpath = "(//span[normalize-space()='Marketing'])[1]")
	WebElement mrktLink;

	@FindBy(xpath = "//label[normalize-space()='Sites']")
	WebElement sitesBtn;

	@FindBy(xpath = "(//a[@class='act-btn cta-btn'])[1]")
	WebElement zohoSitesTxt;


	public void clickProdDrpDwn() 
	{
		prodDrpdwn.click();
	}

	public void clickMrktLink() 
	{
		mrktLink.click();
	}
	public void clickSitesBtn() 
	{
		sitesBtn.click();
	}
	public String getZohoSitesTxt() 
	{
		String text = zohoSitesTxt.getText();
		return text;
	}
}
