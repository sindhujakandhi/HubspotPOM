package com.qa.Hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basepage {

	public WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver() {
		System.setProperty("webdriver.chrome.driver", "/Users/nareshguggilla/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().window().fullscreen();
		tdriver.set(driver);
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	public Properties init_Properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"/Users/nareshguggilla/Documents/Selenium_Sessions/HubspotPOMSeries/src/main/java/com/qa/Hubspot/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenShot() {
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
