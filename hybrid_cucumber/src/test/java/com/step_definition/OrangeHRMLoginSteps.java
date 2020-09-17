package com.step_definition;



import com.base_class.Library;
import com.pages.OrangeHRMLoginPage;
import com.selenium_reusablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMLoginSteps extends Library{

	    OrangeHRMLoginPage orangeHRMLoginPage;
	   SeleniumUtility seleniumUtility;
		
		@Given("To launch the browser and Navigate to the Url")
		public void to_launch_the_browser_and_Navigate_to_the_Url() {
		    browserSetUp();
		    logger.info("Browser Launched");
		}
		
		@When("To Enter Username and Password")
		public void to_Enter_Username_and_Password() {
			orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
		    orangeHRMLoginPage.LoginUser(properties.getProperty("username"),properties.getProperty("password"));   
		    logger.info("Entered username and Password");
		}
		
		@Then("To Click the Submit button")
		public void to_Click_the_Submit_button() {
		  orangeHRMLoginPage = new OrangeHRMLoginPage(driver);	
		  orangeHRMLoginPage.Submit();
		  logger.info("Login Button Clicked");
		}
		
		@Then("To Take the Screenshot and the Title")
		public void to_Take_the_Screenshot_and_the_Title() {
			seleniumUtility = new SeleniumUtility(driver);
			seleniumUtility.to_take_screenshot("LoginPage1");
			seleniumUtility.getTitle();
			logger.info("Taken Screenshot Of Login Page And Title printed in console");
		}
		
		@Then("To Close the browser")
		public void to_Close_the_browser() {
			tearDown();
		}
		
}