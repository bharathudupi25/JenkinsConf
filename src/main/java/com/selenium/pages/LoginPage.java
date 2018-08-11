package com.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//font[text()='Sign Up']")
	WebElement signUpButton;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement logo;
	
	@FindBy(xpath="//font[contains(text(),'Naveen')]")
	WebElement afterLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyImage() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
//		loginButton.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginButton);
		return new HomePage();
	}
	
	public String verifyAfterLogin() {
		return afterLogin.getText();
	}
	
	public void clickOnSignUp() {
//		signUpButton.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signUpButton);
	}
}


