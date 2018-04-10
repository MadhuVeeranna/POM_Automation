package com.rda.automation.testAutomation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractiseRegistrationPage {
	
	public static final Logger log = Logger.getLogger(AutomationPractiseRegistrationPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(id="email_create")
	WebElement createAccountEmailID;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccountButton;
	
	@FindBy(id="id_gender1")
	WebElement gender;
	
	@FindBy(id="customer_firstname")
	WebElement reg_FirstName;
	
	@FindBy(id="customer_lastname")
	WebElement reg_LastName;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
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
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	WebElement registerButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	WebElement signOut;
	
	/*
	 * Since it is a page factory approach always we have to create the constructor of a class
	 * to initialize the web elements, Because web element is the return type of driver.findby() then only
	 * we can invoke the methods of the web element else we will get null pointer exception if we do not initialize.
	 */
	public AutomationPractiseRegistrationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userRegister(String emailAddress, String firstName, String lastName, String password, String day, String month, String year, String company, String address1, String address2, String city, String state, String zipCode, String country, String additionalInfo, String homePhone, String mobilePhone, String alias){
		signIn.click();
		log.info("Clicked on sign in and object is "+signIn.toString());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createAccountEmailID));
		createAccountEmailID.click();
		createAccountEmailID.sendKeys(emailAddress);
		log.info("Entered email address is:- "+emailAddress+" and object is "+createAccountEmailID.toString());
		/* Scroll to particular element
		 * WebElement element =createAnAccountButton ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 */
		//To Scroll to the half of window
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
		createAnAccountButton.click();
		log.info("Clicked on Create Account button and object is"+createAnAccountButton.toString());
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		log.info("Clicked on Create Account button and object is"+gender.toString());
		reg_FirstName.click();
		reg_FirstName.sendKeys(firstName);
		log.info("Entered first name is:- "+firstName+" and object is "+reg_FirstName.toString());
		reg_LastName.click();
		reg_LastName.sendKeys(lastName);
		log.info("Entered last name is:- "+lastName+" and object is "+reg_LastName.toString());
		this.emailAddress.click();
		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
		log.info("Entered email address is:- "+emailAddress+" and object is "+this.emailAddress.toString());
		reg_Passwd.sendKeys(password);
		log.info("Entered password is:- "+password+" and object is "+reg_Passwd.toString());
		Select selectDay = new Select(days);
		selectDay.selectByValue(day);
		log.info("Entered day is:- "+day+" and object is "+days.toString());
		Select selectMonth = new Select(months);
		selectMonth.selectByValue(month);
		log.info("Entered month is:- "+month+" and object is "+months.toString());
		Select selectYear = new Select(years);
		selectYear.selectByValue(year);
		log.info("Entered month is:- "+year+" and object is "+years.toString());
		companyName.click();
		companyName.sendKeys(company);
		log.info("Clicked on company name and entered information is "+company+" and object is "+companyName.toString());
		reg_Address1.click();
		reg_Address1.sendKeys(address1);
		log.info("Clicked on company name and entered information is "+address1+" and object is "+reg_Address1.toString());
		reg_Address2.click();
		reg_Address2.sendKeys(address2);
		log.info("Clicked on company name and entered information is "+address2+" and object is "+reg_Address2.toString());
		reg_City.click();
		reg_City.sendKeys(city);
		log.info("Clicked on company name and entered information is "+city+" and object is "+reg_City.toString());
		Select selectState = new Select(reg_State);
		selectState.selectByVisibleText(state);
		log.info("Clicked on state and passed infomration is "+state+" and object is "+reg_State.toString());
		reg_PostalCode.click();
		reg_PostalCode.sendKeys(zipCode);
		log.info("Clicked on postal code and passed infomration is "+zipCode+" and object is "+reg_PostalCode.toString());
		Select selectCountry = new Select(reg_Country);
		selectCountry.selectByVisibleText(country);
		log.info("Clicked on Country and passed infomration is "+country+" and object is "+reg_Country.toString());
		reg_AdditionalInfomration.click();
		reg_AdditionalInfomration.sendKeys(additionalInfo);
		log.info("Clicked on Additional Info and passed infomration is "+additionalInfo+" and object is "+reg_AdditionalInfomration.toString());
		reg_HomePhone.click();
		reg_HomePhone.sendKeys(homePhone);
		log.info("Clicked on home phone and passed infomration is "+homePhone+" and object is "+reg_HomePhone.toString());
		reg_MobilePhone.clear();
		reg_MobilePhone.sendKeys(mobilePhone);
		log.info("Clicked on moble phone and passed infomration is "+mobilePhone+" and object is "+reg_MobilePhone.toString());
		reg_Alias.click();
		reg_Alias.sendKeys(alias);
		log.info("Clicked on Alias and passed infomration is "+alias+" and object is "+reg_Alias.toString());
		registerButton.click();
		log.info("Clicked on register button and object is"+registerButton.toString());
		wait.until(ExpectedConditions.elementToBeClickable(signOut));
		log.info("Waited for element to appear!! SignOutElement visible and object is" +signOut.toString());
	}
	
	

	
}
