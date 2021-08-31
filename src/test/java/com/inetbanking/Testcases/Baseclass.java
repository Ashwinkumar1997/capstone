package com.inetbanking.Testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utlities.Readconfig;

public class Baseclass {
	Readconfig rc=new Readconfig();
	public String url=rc.getApplicationURL();
	public String password=rc.getPassword();
	public String username=rc.getUsername();
	public static WebDriver driver;
	
	public static Logger logger;
			
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
	    logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rc.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getChromepath());
			driver=new ChromeDriver();
			
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEpath());
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", rc.getEdgepath());
			driver=new EdgeDriver();
		}
		driver.get(url);
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	public void capturescreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot) driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		File dst=new File(System.getProperty("user.dir")+"\\Screenshot\\"+tname+".png");
		FileUtils.copyFile(src, dst);
		System.out.println("screenshot is taken");
	}
	

}
