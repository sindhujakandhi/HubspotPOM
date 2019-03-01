package com.qa.Hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Hubspot.base.Basepage;
import com.qa.Hubspot.constants.Constants;
import com.qa.Hubspot.pages.LoginPage;

public class LoginTest {
	
	Basepage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basepage = new Basepage();
		driver =basepage.init_driver();
		prop = basepage.init_Properties();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("LoginPage Title is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority = 2)
	public void VerifySignUpLinkTest() {
		boolean link = loginPage.VerifySignUpLink();
		Assert.assertTrue(link);
	}
	
	@Test(priority = 3)
	public void verifyLoginTest() {
		loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
