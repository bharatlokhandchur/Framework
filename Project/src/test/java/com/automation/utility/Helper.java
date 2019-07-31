package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/FreeCRM_" + getCurrentDateTime()
				+ ".png";

		try {

			FileHandler.copy(src, new File(screenshotPath));
			System.out.println(" ScreenShot Captured ");

		} catch (IOException e) {
			System.out.println("Unable to Capture ScreenShot" + e.getMessage());
		}

		return screenshotPath;
	}

	public static String getCurrentDateTime() {
		DateFormat customDate = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentdate = new Date();
		return customDate.format(currentdate);
	}

}
