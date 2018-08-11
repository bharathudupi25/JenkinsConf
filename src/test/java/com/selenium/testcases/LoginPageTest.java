package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.base.TestBase;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.utils.TestUtils;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtils = new TestUtils();
	}
	
//	@Test(priority=1)
//	public void loginPageTitleTest() {
//		String title = loginPage.verifyLoginPageTitle();
//		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
//	}
//	
//	@Test(priority=2)
//	public void logoTest() {
//		boolean flag = loginPage.verifyImage();
//		Assert.assertTrue(flag);
//	}
//	
//	@Test(priority=3)
//	public void loginTest() {
//		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
//	}
	
	@Test
	public void loginPageTestMethod() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		boolean flag = loginPage.verifyImage();
		Assert.assertTrue(flag);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
		String text = loginPage.verifyAfterLogin();
		Assert.assertEquals(text, "  User: Naveen K");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
