package com.rda.automation.testAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPractiseLoginPage {
	
	public static final Logger log = Logger.getLogger(AutomationPractiseLoginPage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(id="email")
	WebElement loginEmailAddress;
	
	@FindBy(id="passwd")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")
	WebElement authenticationFailed;
	
	/*
	 * Since it is a page factory approach always we have to create the constructor of a class
	 * to initialize the web elements, Because web element is the return type of driver.findby() then only
	 * we can invoke the methods of the web element else we will get null pointer exception if we do not initialize.
	 */
	
	public AutomationPractiseLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String emailAddress, String password){
		signIn.click();
		log.info("Clicked on sign in and object is "+signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("Entered email address is:-"+emailAddress+" and object is " +loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("Entered password is:-"+password+" and object is "+password.toString());
		submitButton.click();
		log.info("Clicked on submit button and object is "+submitButton.toString());
	}
	
	public String getInvalidLoginText(){
		log.info("Error message is:- "+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
}
