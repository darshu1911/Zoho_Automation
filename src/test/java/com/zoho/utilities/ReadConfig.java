package com.zoho.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;	
	String path = "D:\\Automation\\Selenium\\Zoho_Automtion\\Configuration\\config";

	public ReadConfig() 
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl()
	{	
		String value = prop.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");

	}

	public String getBrowser() 
	{		
		String value = prop.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
	}
	
	public String getEmailID() 
	{		
		String value = prop.getProperty("EmailID");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("EmailID not specified in config file");
	}
	
	public String getPassword() 
	{		
		String value = prop.getProperty("Password");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("Password is not specified in config file");
	}
	
	public String getAccount() 
	{		
		String value = prop.getProperty("account");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("Account not specified in config file");
	}

}
