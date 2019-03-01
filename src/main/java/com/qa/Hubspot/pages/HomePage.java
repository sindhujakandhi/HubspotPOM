package com.qa.Hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Hubspot.base.Basepage;
import com.qa.Hubspot.constants.Constants;
import com.qa.Hubspot.util.TestUtil;

public class HomePage extends Basepage {
	
	@FindBy(className = "private-page__title")
	WebElement homePage_header;
	

	@FindBy(id = "nav-primary-contacts-branch1212")
	WebElement contacts_tab;
	
	
	@FindBy(id = "nav-secondary-contacts")
	WebElement contacts_link;
	
	

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
}
	
	
	public String verifyHomePageTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		String title = driver.getTitle();
		System.out.println("Home page title is " +title);
		return title;
	}
	
	
	public boolean verifyHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homePage_header));
		return homePage_header.isDisplayed();
	}
	
	public String getHeaderText() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homePage_header));
		
		return homePage_header.getText();
		
		
	}
	
	public ContactsPage clickOnContactsLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(contacts_tab));
		
		contacts_tab.click();
		TestUtil.shortWait();
		
		contacts_link.click();
		return new ContactsPage(driver);
	}

}
