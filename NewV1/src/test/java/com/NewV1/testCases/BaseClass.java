package com.NewV1.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.NewV1.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String Email =   readconfig.getEmail();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver" , readconfig.getChromePath());
	    driver = new ChromeDriver();
	    
//	    logger = Logger.getLogger("Facebook");
//	    PropertyConfigurator.configure("property.xml");
	    
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
}
