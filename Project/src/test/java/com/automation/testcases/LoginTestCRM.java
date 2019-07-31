package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.automation.pages.LoginPage;

import com.automation.pages.BaseClass;

public class LoginTestCRM extends BaseClass {

	@Test

	public void loginApp() {

		report.createTest("Login to CRM ");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginToCRM(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));

		logger.pass("login Successful");

	}

}
