package com.rda.automation.testAutomation.customlistner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount = 3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount < maxRetryCount){
			retryCount++;
			return true;
		}
		return false;
	}

}
