package com.qa.facebook.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.facebook.base.BasePage;
import com.qa.facebook.constants.Constants;
import com.qa.facebook.pages.LoginPage;
import com.qa.facebook.util.ExcelUtil;
import com.qa.facebook.util.TimeUtil;

public class LoginPageTest {
	BasePage basePage; 
	Properties prop;
	LoginPage loginPage;
	WebDriver driver;
	
	//Pre condition
	@BeforeMethod
	public void setUp(){		
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
				
	}
//	@Test
//	public void loginTest(){
//		loginPage.doLogin();
//	}
	//Test case-01
	@Test(enabled=false)
	public void loginTest() throws Exception{
		TimeUtil.mediumWait();
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Test case -02
	@Test(enabled=false)
	public void verifyLoginPageTitleTest() throws Exception{
		TimeUtil.mediumWait();
		String title = loginPage.getLoginPageTitle();
		System.out.println("The login page title is "+title);		
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@DataProvider(name="getCredentials")
	public Object[][] getContactData(){
		Object contactsData[][] = ExcelUtil.getTestData("Sheet1");
		return contactsData;
	}
	
	
	@Test(dataProvider="getCredentials")
	public void retesting(String uname,String pwd){
		loginPage.doLogin(uname, pwd);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	
	
}
