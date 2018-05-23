package com.rda.automation.testAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.rda.automation.testAutomation.excelReader.Excel_Reader;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	//Will declare the webdriver as Static, because we want this driver to be available across the project hence static.
	public static WebDriver driver;
	//String url = "http://automationpractice.com/index.php";
	String url = "https://www.jabong.com/";
	String browser = "chrome";
	Excel_Reader excel;
	
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jConfigPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
	}
	
	public void selectBrowser(String browser){
		 if(browser.equalsIgnoreCase("firefox")){
			 //For Windows
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			 //For Mac
			 //System.setProperty("Webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");		 
			 log.info("Creating object of "+browser);
			 driver = new FirefoxDriver();
		 }
		 else if(browser.equalsIgnoreCase("chrome")){
			 System.out.println(System.getProperty("user.dir"));
			 //For Windows 64 bit
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			 //For Mac
			 //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			 log.info("Creating object of "+browser);
			 driver = new ChromeDriver();
		 }
	 }
	 
	 public void getUrl(String url){
		 log.info("Navigating to "+url);
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		/* This code will get all the windows ID and we can switch using the windows ID
		 * Set<String> window = driver.getWindowHandles();
		 Iterator<String> itr = window.iterator();
		 String parentwindow = itr.next();
		 String childwindow = itr.next();
		 driver.switchTo().window(childwindow);*/
	 }
	 
	 //Overriding the excel data reader method as this method functionality will be required by different test scripts
	 public String[][] getData(String excelName, String sheetName){
		 String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\rda\\automation\\testAutomation\\data\\"+excelName;																																																			
		 excel = new Excel_Reader(path);
		 String[][] data = excel.getDataFromSheet(sheetName, excelName);
		 return data;
	 }
	 
	  public void getScreenShot(String name){
		//Creating the calendar object
		 Calendar calendar = Calendar.getInstance();
		 //Creating the date format to store the file with date name
		 String timeStamp = new SimpleDateFormat("dd_mm_yyYY_hh_mm_ss").format(calendar.getTime());
		 //Directly we cannot take the screenshot using selenium webdriver, we have to cast the driver object to screenshot class using curly braces
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//Screenshot captured at runtime

		 try {
			//Featching the location where we have to store the screenshot file
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\rda\\automation\\testAutomation\\screenshot\\";
			 File destFile = new File((String)reportDirectory + name + "_" + timeStamp + ".png");//DestFile created at runtime
			 FileUtils.copyFile(srcFile, destFile);
			 //below log will help us to link the screenshot in to testNG report
			 //To convert the path to string we are writing '" and "'. Reporter.log will take only string value
			 Reporter.log("<a href ='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()+ "' height='100' width='100'/> </a>");
			 /*String path = "<img src=\"file://" + destFile + "\" alt=\"\"/>";
			 Reporter.log(path);
			 */
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	 } 
	  
	 public Iterator<String> getAllWindows(){
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> itr = windows.iterator();
		 return itr;
	 }
	 
	
}