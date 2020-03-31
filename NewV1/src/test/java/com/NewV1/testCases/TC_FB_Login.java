package com.NewV1.testCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.NewV1.PageObjectClass.LoginPage;

import junit.framework.Assert;

public class TC_FB_Login extends BaseClass {
	
	  
	@Test
	public void mainTest()
	{
		driver.get(baseURL);

		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(Email);
		//logger.info("Entering Login Credential");

		
		lp.setPassword(Password);
		//logger.info("Entering the password");

		
		//logger.info("Clicking on Login button");
		lp.clkSubmit();
		
		/*(if(driver.getCurrentUrl().equals("https://www.facebook.com/groups/"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}*/
	}
	

}
