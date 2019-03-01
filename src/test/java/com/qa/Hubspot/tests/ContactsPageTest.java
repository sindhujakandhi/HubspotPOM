package com.qa.Hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Hubspot.base.Basepage;
import com.qa.Hubspot.constants.Constants;
import com.qa.Hubspot.pages.ContactsPage;
import com.qa.Hubspot.pages.HomePage;
import com.qa.Hubspot.pages.LoginPage;
import com.qa.Hubspot.util.TestUtil;

public class ContactsPageTest {
	Basepage basePage;
	HomePage homePage;
	LoginPage loginPage;
	WebDriver driver;
	Properties prop;
	ContactsPage contactsPage;
	
	
	@BeforeMethod
	
	public void SetUp() {
		basePage = new Basepage();
		driver = basePage.init_driver();
		prop = basePage.init_Properties();
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		homePage = loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		 contactsPage = homePage.clickOnContactsLink();	
	}
	
	@DataProvider(name = "contactsTestData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = TestUtil.getTestContactsData(Constants.CONTACTS_SHEET_NAME);
		return contactsData;
	}
	
	@Test(dataProvider = "contactsTestData")
	public void verifyCreateContactButtonTest(String email, String firstname , String lastname, String jobtitle) {
		contactsPage.verifyCreateContactButton(email, firstname,lastname, jobtitle);
	}
	
@AfterMethod
    public void tearDown() {
	driver.quit();
}

}
