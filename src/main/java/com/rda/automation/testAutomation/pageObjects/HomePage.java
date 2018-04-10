package com.rda.automation.testAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rda.automation.testAutomation.testBase.TestBase;

public class HomePage extends TestBase {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
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
	
	@FindBy(id="email_create")
	WebElement createAccountEmailID;
	
	@FindBy(xpath=".//input[@value='Create an account']")
	WebElement createAnAccountButton;
	
	@FindBy(id="id_gender1")
	WebElement gender;
	
	@FindBy(id="customer_firstname")
	WebElement reg_FirstName;
	
	@FindBy(id="customer_lastname")
	WebElement reg_LastName;
	
	@FindBy(id="passwd")
	WebElement reg_Passwd;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="firstname")
	WebElement reg_FirstNameAddress;
	
	@FindBy(id="lastname")
	WebElement reg_LastNameAddress;

	@FindBy(id="company")
	WebElement companyName;
	
	@FindBy(id="address1")
	WebElement reg_Address1;
	
	@FindBy(id="address2")
	WebElement reg_Address2;
	
	@FindBy(id="city")
	WebElement reg_City;
	
	@FindBy(id="id_state")
	WebElement reg_State;
	
	@FindBy(id="postcode")
	WebElement reg_PostalCode;
	
	@FindBy(id="id_country")
	WebElement reg_Country;
	
	@FindBy(id="other")
	WebElement reg_AdditionalInfomration;
	
	@FindBy(id="phone")
	WebElement reg_HomePhone;
	
	@FindBy(id="phone_mobile")
	WebElement reg_MobilePhone;
	
	@FindBy(id="alias")
	WebElement reg_Alias;
	
	//Constructor of class
	public HomePage(WebDriver driver){
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
		log.info("Error message is "+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	
	
	//Jabong site scripts
	public void jabongUserRegister(String firstName, String lastName, String email,String password, String mobileNumber){
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