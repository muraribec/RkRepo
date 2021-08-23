package com.qa.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.facebook.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author murari kumar
 *
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the WebDriver
	 * @param prop
	 * @return WebDriver
	 */
	public WebDriver initialize_driver(Properties prop){
		
		String browserName=prop.getProperty("browser");		
		if(browserName.equals("chrome")){			
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();		}
		else if(browserName.equals("IE")){
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
			 }
		else{
			System.out.println("Browser"+browserName+"is not define in the peroperties file,Pls correct the browser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		return driver;
		
	}
	
	/**
	 * This method is used to initilaize the properties file and return the peroperties reference 
	 * @return Properties
	 */
	public Properties initialize_Properties(){		
		prop = new Properties();		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO PC\\workspace\\RkAutomationProject\\src\\main\\java\\com\\qa\\facebook\\configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return prop;
	}
	
	
	
	
	
	
}
