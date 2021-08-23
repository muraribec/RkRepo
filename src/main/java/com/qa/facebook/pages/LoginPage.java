package com.qa.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.base.BasePage;

public class LoginPage extends BasePage{
	
	//1.Page Object/data members/
	
	@FindBy(id="email")
	WebElement emailId;
	
	
	@FindBy(name="pass")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id='loginbutton']")
	WebElement loginBtn;
	
	
	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//2create constructor to initialize the page objects/webelements
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3 Page Actions/Member function
	
	public void doLogin(String usename,String passd){
//		emailId.sendKeys(usename);
//		pwd.sendKeys(passd);
//		loginBtn.click();
		getEmailId().sendKeys(usename);
		getPwd().sendKeys(passd);
		getLoginBtn().click();
		
	}
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
