package com.netBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;

public class TC_LoginTest_002 extends BaseClass{
	
	@Test
	public void newCustomer() throws InterruptedException, IOException {
		driver.get(baseURL);
		Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
	
		lp.setPassword(password);
		takeSnapShot(driver, "Credentials");
		
		lp.clickSubmit();
		Thread.sleep(5000);
		takeSnapShot(driver,"Successfully Logged In"); 
		
		/*TC_LoginTest_001 tc1 = new TC_LoginTest_001();
		tc1.LoginTest(); */
		
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Dob);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Address);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(Email);
		
		takeSnapShot(driver,"New Customer Details");	
		String className = this.getClass().getSimpleName();
		PDF(imagepath, className, description);
	}

}
