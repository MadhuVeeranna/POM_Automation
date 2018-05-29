package com.rda.automation.testAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.rda.automation.testAutomation.pageObjects.AutomationPractiseRegistrationPage;
import com.rda.automation.testAutomation.testBase.TestBase;

public class TC003_VerifyRegistration extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC003_VerifyRegistration.class.getName());
	AutomationPractiseRegistrationPage automationpractiseregistrationpage;
	String emailAddress = "madhuveeranna"+System.currentTimeMillis()+"@gmail.com";
	String firstName = "Madhu";
	String lastName = "veeranna";
	String password = "M@dhu9093";
	String day = "11";
	String month = "10";
	String year = "1993";
	String company = "RDA Labs india PVT LTD";
	String address1 = "#117 1st main road 4th cross";
	String address2 = "Vijaylakshmi layout Bagalgunte";
	String city = "Bangalore";
	String state = "Indian";
	String zipCode = "56007";
	String country = "United States";
	String additionalInfo = "I am working as Sr Associate Engineer in the QA Department";
	String homePhone = "9035832317";
	String mobilePhone = "9035832317";
	String alias = "Maddy";
	
	@BeforeTest
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void userRegistration() {
		log.info(" ======== Starting userRegistration ======== ");
		automationpractiseregistrationpage = new AutomationPractiseRegistrationPage(driver);
		automationpractiseregistrationpage.userRegister(emailAddress, firstName, lastName, password, day, month, year, company, address1, address2, city, state, zipCode, country, additionalInfo, homePhone, mobilePhone, alias);
		log.info(" ======== Finished userRegistration ======== ");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
	

}
