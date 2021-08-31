package com.inetbanking.Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.utlities.XLUtilities;

public class Testcase2 extends Baseclass {
	@Test(dataProvider="LoginData")
	public void loginDTT(String user1, String pass1)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user1);
		lp.setpassword(pass1);
		lp.clicksubmit();
		
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("D:/ashwin/inetbanking/src/test/java/com/inetbanking/Testdata/blaze.xlsx");
		
		int rownum=XLUtilities.getRowCount(path, "Sheet1");
		int colcount=XLUtilities.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
