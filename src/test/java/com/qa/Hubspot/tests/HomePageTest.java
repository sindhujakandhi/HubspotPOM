package com.qa.Hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.Hubspot.base.Basepage;
import com.qa.Hubspot.constants.Constants;
import com.qa.Hubspot.pages.HomePage;
import com.qa.Hubspot.pages.LoginPage;

public class HomePageTest {
	Basepage basePage;
	WebDriver driver;
	Properties prop;
	HomePage homePage;
	
	@BeforeMethod
	
	public void setUp() {
		
		basePage = new Basepage();
		driver = basePage.init_driver();
		prop = basePage.init_Properties();
		driver.get(prop.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		 homePage = loginPage.verifyLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title= homePage.verifyHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void verifyHeaderTest() {
		Assert.assertTrue(homePage.verifyHeader());
		String value = homePage.getHeaderText();
		Assert.assertEquals(value, Constants.HOME_PAGE_HEADER);
	}
	
	
	
	@Test(priority = 3)
	public void verifyContactsTest() {
		homePage.clickOnContactsLink();
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
