package com.NewV1.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.cache.Cache;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,  this);
	}
	
	@FindBy(id ="email")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(id ="pass")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(id ="loginbutton")
	@CacheLookup
	WebElement btnLogin;

	//public String setEmail;

	//public String setPassword;
		
	
		// TODO Auto-generated constructor stub
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void clkSubmit()
	{
		btnLogin.click();
	}
	/*pubEic void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}*/
}