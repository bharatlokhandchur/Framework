/**
 * 
 */
package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Kapil
 *
 */
public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browsername, String appUrl)

	{

		if (browsername.equals("Chorme")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe ");
			driver = new ChromeDriver();
		} else if (browsername.equals("Firefox"))

		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe ");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe ");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("We DoseNot Support This Browser");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(appUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();

	}

}
