package com.rda.automation.testAutomation.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rda.automation.testAutomation.pageObjects.AutomationPractiseLoginPage;
import com.rda.automation.testAutomation.testBase.TestBase;

public class TC001_VerifyLoginWithInvalidCredentails extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentails.class.getName());
	
	AutomationPractiseLoginPage automationpractiseloginpage; //Reference object to the java class to invoke methods
	String emailAddress = "test@gmail.com";
	String password = "password123";
	//AutomationPractiseLoginPage automationpractiseloginpage = PageFactory.initElements(driver, AutomationPractiseLoginPage.class);/* Initializing page factory elements*/
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentails(){
		log.info(" ======== Starting VerifyLoginWithInvalidCredentails ========");
		automationpractiseloginpage = new AutomationPractiseLoginPage(driver);
		automationpractiseloginpage.loginToApplication(emailAddress, password);
		Assert.assertEquals(automationpractiseloginpage.getInvalidLoginText(), "Authentication failed.");
		log.info(" ======== Finished VerifyLoginWithInvalidCredentails ========");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
