package com.qa.Hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Hubspot.base.Basepage;
import com.qa.Hubspot.util.TestUtil;

public class ContactsPage extends Basepage{
	
	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement primary_createButton;
	
	@FindBy(xpath= "//div[@class = 'private-form__input-wrapper']/div[@class = 'p-x-0 col-xs-12 ']/input")
	WebElement email;
	
	@FindBy(xpath= "//*[@id='uid-ctrl-2']")
	WebElement firstName;
	
	@FindBy(id= "uid-ctrl-3")
	WebElement lastName;
	
	@FindBy(id= "uid-ctrl-5")
	WebElement jobTitle;
	
	@FindBy(xpath= "//li//span[text()= 'Create contact']")
	WebElement second_createButton;
	
	
	
	public ContactsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyCreateContactButton(String emailValue,String fName, String lName, String jTitle) {
	
		WebDriverWait wait =  new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(primary_createButton));
		primary_createButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailValue);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(fName);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lName);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jTitle);
		
		//TestUtil.mediumWait();
		wait.until(ExpectedConditions.elementToBeClickable(second_createButton));
		second_createButton.click();
		
		
	}

}
