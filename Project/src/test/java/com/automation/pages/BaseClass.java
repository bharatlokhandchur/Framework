package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;

	public ExcelDataProvider excel;

	public ConfigDataProvider config;

	public ExtentReports report;

	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {

		Reporter.log("Setting up Reports and Test is getting Ready", true);

		excel = new ExcelDataProvider();

		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html"));

		report = new ExtentReports();
		report.attachReporter(extent);

		Reporter.log("Setting done - Test can be Started ", true);
	}

	@BeforeClass
	public void setup() {

		Reporter.log("Trying to Start Browser and Application Ready ", true);

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringURL());

		Reporter.log("Browser and Application is Up And Running ", true);

	}

	@AfterClass
	public void tearDown()

	{
		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		Reporter.log("Test is about to End ", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}

		report.flush();

		Reporter.log("Test Completed >>>> REports Generated ", true);

	}

}
