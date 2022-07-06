package com.netBanking.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException 
	{
		//takeSnapShots ts = new takeSnapShots();
		driver.get(baseURL);
		Thread.sleep(5000);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter Username");
		
		lp.setPassword(password);
		logger.info("Enter password");
		takeSnapShot(driver, "Credentials");
		
		lp.clickSubmit();
		//logger.info("Click on Login");
		
		Thread.sleep(5000);
		takeSnapShot(driver,"Successfully Logged in");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			//logger.info("Login Test Passed");
		}
		else 
		{
			Assert.assertTrue(false);
			//logger.info("Login Test Failed");
		}
		String className = this.getClass().getSimpleName();
		PDF(imagepath,className, description);
	}
}
