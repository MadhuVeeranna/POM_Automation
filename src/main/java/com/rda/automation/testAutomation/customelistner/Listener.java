package com.rda.automation.testAutomation.customelistner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.rda.automation.testAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		String timeStamp = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(calendar.getTime());

		String methodName = result.getName();
		
		if(!result.isSuccess()){	
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\rda\\automation\\testAutomation\\config";
				File destFile = new File((String)reportDirectory + "//failure_screenshots//" + methodName + timeStamp + ".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()+"' height='100', weidth='100'/> </a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
