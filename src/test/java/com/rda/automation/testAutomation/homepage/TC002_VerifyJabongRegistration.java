package com.rda.automation.testAutomation.homepage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.rda.automation.testAutomation.pageObjects.JabongRegistrationPage;
import com.rda.automation.testAutomation.testBase.TestBase;

public class TC002_VerifyJabongRegistration extends TestBase{
	
	//Extra Script written on Jabong site
	public static final Logger log = Logger.getLogger(TC002_VerifyJabongRegistration.class.getName());
	JabongRegistrationPage jabongregistrationpage;
	String firstName = "Madhu";
	String lastName = "Veeranna";
	//String email = "madhuveede11ewe2e@gmail.com";
	String email = "madhuveeranna"+System.currentTimeMillis()+"@gmail.com";
	String password = "M@dhu9093";
	String mobileNumber = "1"+System.currentTimeMillis();
	//String mobileNumber = "9222122319";
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	
	@Test
	public void verifyJabongRegistration() throws InterruptedException{
			log.info(" ======== Starting VerifyRegistration with valid credentials ========");
			jabongregistrationpage = new JabongRegistrationPage(driver);
			System.out.println(email);
			jabongregistrationpage.userRegister(firstName, lastName, email, password, mobileNumber);
			jabongregistrationpage.getRegistrationSuccess();
			Assert.assertEquals(true, jabongregistrationpage.getRegistrationSuccess());
			log.info(" ======== Finished VerifyRegistration with valid credentials ========");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
