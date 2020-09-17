package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base_class.Library;
import com.pages.OrangeHRMLoginPage;
import com.selenium_reusablefunction.SeleniumUtility;


public class OrangeHRMLoginTestCase extends Library{
	OrangeHRMLoginPage lpage;
	SeleniumUtility seleniumUtil;
	
	@BeforeTest
	public void launchApp()
	{
		browserSetUp();
		logger.info("Browser Launched");
	}
	
	@Test
	public void login() {
		lpage=new OrangeHRMLoginPage(driver);
		lpage.LoginUser(properties.getProperty("username"),properties.getProperty("password"));
		logger.info("Browser Login Successfully");
	}
	
	
	@AfterTest
	public void close() {
		
		seleniumUtil = new SeleniumUtility(driver);   
		seleniumUtil.getTitle();
		seleniumUtil.to_take_screenshot("loginPage");
		tearDown();
		logger.info("Closing Browser");
	}
}
