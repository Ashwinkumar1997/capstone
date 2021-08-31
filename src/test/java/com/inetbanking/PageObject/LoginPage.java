package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	@FindBy(name="username")
	@CacheLookup
	WebElement txtuname;
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpass;
	@FindBy(name="signon")
	@CacheLookup
	WebElement button;
	
	public void setusername(String uname)
	{
		txtuname.sendKeys(uname);
	}
	public void setpassword(String pass)
	{
		txtpass.sendKeys(pass);
	}
	public void clicksubmit()
	{
		button.click();
	}
	

}
