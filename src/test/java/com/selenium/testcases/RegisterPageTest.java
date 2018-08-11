package com.selenium.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.base.TestBase;
import com.selenium.pages.LoginPage;
import com.selenium.pages.RegisterPage;
import com.selenium.utils.TestUtils;

public class RegisterPageTest extends TestBase {
	
	RegisterPage register;
	LoginPage login;
//	TestUtils utils;
	String sheetName = "register";
	Logger log = Logger.getLogger(RegisterPageTest.class);
	
	public RegisterPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setup() {
		initialization();
		register = new RegisterPage();
		login = new LoginPage();
		login.clickOnSignUp();
//		utils = new TestUtils();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void registerPageTestMethod(String firstName, String lastName, String emailId) {
//		register.registerAccount("Bharath", "Bhat", "Test@test.com");
		register.registerAccount(firstName, lastName, emailId);
		log.info("Details has been entered");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
