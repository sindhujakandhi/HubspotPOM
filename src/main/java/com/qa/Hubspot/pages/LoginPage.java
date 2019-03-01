package com.qa.Hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Hubspot.base.Basepage;

public class LoginPage extends Basepage{
	
	@FindBy(id="username")
	WebElement email_address;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText ="Sign up")
	WebElement signupLink;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// this means here initialize current class elements
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public boolean VerifySignUpLink() {
		return signupLink.isDisplayed();
	}
	
	public HomePage verifyLogin(String uname, String pwd) {
		email_address.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
		
	}

}
