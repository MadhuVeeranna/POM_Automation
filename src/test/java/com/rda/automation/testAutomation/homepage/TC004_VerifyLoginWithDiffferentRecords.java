package com.rda.automation.testAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rda.automation.testAutomation.pageObjects.AutomationPractiseLoginPage;
import com.rda.automation.testAutomation.testBase.TestBase;

public class TC004_VerifyLoginWithDiffferentRecords extends TestBase{
	
public static final Logger log = Logger.getLogger(TC004_VerifyLoginWithDiffferentRecords.class.getName());
	
	AutomationPractiseLoginPage automationpractiseloginpage;
	//String emailAddress = "automation@gmail.com";
	//String password = "test123";
	
	@DataProvider(name="loginData") //A Data Provider returns an array of objects. Help us to run the script for multiple set of data. 
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData"); //Excel name and Sheet name
		return testRecords;
	}
	
	@BeforeTest
	public void setUp(){
		init();
	}	
	
	@Test(dataProvider="loginData")
	public void testLogin(String emailAddress, String password, String runMode) throws Exception{
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("User has marked this record not to run");
		}
		log.info(" ======== Starting VerifyLoginWithDiffferentRecords Test ========");
		System.out.println(driver);
		automationpractiseloginpage = new AutomationPractiseLoginPage(driver);
		automationpractiseloginpage.loginToApplication(emailAddress, password);
		getScreenShot("testLogin"+emailAddress);
		
		log.info(" ======== Finished VerifyLoginWithDiffferentRecords Test ========");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}

}
