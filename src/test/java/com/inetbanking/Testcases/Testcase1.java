package com.inetbanking.Testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;

public class Testcase1 extends Baseclass {
	@Test
	public void tc1() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("entered password");
		lp.clicksubmit();
		String title = driver.getTitle();
		System.out.println(title);
		
		if(driver.getTitle().equals(title))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			capturescreenshot(driver, "tc1");
			
			Assert.assertFalse(false);
			logger.info("login test failed");
		}
	}
	

}
