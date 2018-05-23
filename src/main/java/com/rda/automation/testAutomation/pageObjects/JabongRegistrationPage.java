package com.rda.automation.testAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JabongRegistrationPage {
	
	public static final Logger log = Logger.getLogger(JabongRegistrationPage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Signup')]")
	WebElement signUp;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pwd")
	WebElement password;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="female")
	WebElement female;
	
	@FindBy(id="male")
	WebElement male;
	
	@FindBy(id="btn-signup")
	WebElement signUpButton;
	
	@FindBy(xpath="//*[@id=\"top-success\"]/li/span[2]")
	WebElement registrationMessage;
	
	/*
	 * Since it is a page factory approach always we have to create the constructor of a class
	 * to initialize the web elements, Because web element is the return type of driver.findby() then only
	 * we can invoke the methods of the web element else we will get null pointer exception if we do not initialize.
	 */
	public JabongRegistrationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userRegister(String firstName, String lastName, String email,String password, String mobileNumber){
		signUp.click();
		log.info("Clicked on sign-up link and object is:-"+signUp.toString());
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(this.firstName));
		//Switching window
		String signUpWindow = driver.getWindowHandle();
		driver.switchTo().window(signUpWindow);
		log.info("Switched to signup window and object is:-"+signUpWindow.toString());
		this.firstName.click();
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		log.info("Entered data to firstName field:-"+firstName+" and object is:-"+this.firstName.toString());
		this.lastName.click();
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		log.info("Entered data to lastName field:-"+lastName+" and object is:-"+this.lastName.toString());
		this.email.click();
		this.email.clear();
		this.email.sendKeys(email);
		log.info("Entered data to email field:-"+email+" and object is:-"+this.email.toString());
		this.password.click();
		this.password.clear();
		this.password.sendKeys(password);
		log.info("Entered data to password field:-"+password+" and object is:-"+this.password.toString());
		mobile.click();
		mobile.clear();
		mobile.sendKeys(mobileNumber);
		log.info("Entered data to mobile number field:-"+mobileNumber+" and object is:-"+this.mobile.toString());
		female.click();
		log.info("Selected female option and object is:-"+this.female.toString());
		male.click();
		log.info("Selected male option and object is:-"+this.male.toString());
		signUpButton.click();
		log.info("Clicked on signUp button and object is:-"+signUpButton.toString());
	}
	
	//Jabong site scripts
	public boolean getRegistrationSuccess(){
		//log.info("Registration message is:-"+registrationMessage.getText());
		try {
			registrationMessage.isDisplayed();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
