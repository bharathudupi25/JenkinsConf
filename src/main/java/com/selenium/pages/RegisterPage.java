package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='agreeTerms']")
	WebElement agreeCheckBox;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void registerAccount(String fName, String lName, String emailId) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		agreeCheckBox.click();
	}
	
}
