package com.zoho.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestListner implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() 
	{

		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName = "ZohoTestReport-" + timestamp + ".html";
		htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system information/environment info to reports
		reports.setSystemInfo("Machine", "testPC1");
		reports.setSystemInfo("OS", "Windows 10");

		reports.setSystemInfo("browser", readConfig.getBrowser());
		reports.setSystemInfo("user name", "Darshan H M");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("user name", "Darshanhm198");

		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Zoho Report");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	//onStart method is called when any test starts
	public void onStart(ITestContext Result) 
	{
		configureReport();
		System.out.println("On Start method invoked");
	}

	//onFinish method is called when all test are executed
	public void onFinish(ITestContext Result) 
	{
		System.out.println("On Finished method invoked");
		reports.flush();// it is mandatory to call flush method to ensure information is written to the started reporter.	
	}

	//When test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of the test method failed:"+ Result.getName());
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File screenshotfile = new File(screenshotPath);
		

		 if (screenshotfile.exists()) {
		        test.fail("Captured Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
	}

	//When test case get Skipped, this method is called
	public void onTestSkiped(ITestResult Result) 
	{
		System.out.println("Name of the test method skipped:"+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skiped test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}

	//when test case get started, this method is called.
	public void onTestStart(ITestResult Result) 
	{
		System.out.println("Name of test method started:"+ Result.getName());
	}

	//when test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("Name of test method sucessfully passed:"+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}
}