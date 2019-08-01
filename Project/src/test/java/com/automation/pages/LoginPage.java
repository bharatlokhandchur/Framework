package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;	
	}
	
	@FindBy(xpath="//*[@name='username']") WebElement uname;
	
	@FindBy(xpath="//*[@name='password']") WebElement pass; 

	@FindBy(xpath="//input[@value='login']") WebElement loginButton;
	
	
	public void loginToCRM(String usernameApplication, String passwordApplication)
	{
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
		
		
	}

	
	

}
