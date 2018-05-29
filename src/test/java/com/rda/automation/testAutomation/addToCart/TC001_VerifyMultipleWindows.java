package com.rda.automation.testAutomation.addToCart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rda.automation.testAutomation.testBase.TestBase;

public final class TC001_VerifyMultipleWindows extends TestBase{
	
	/*
	 * Handling multiple windows
	 */
	List<String> windowIds = new ArrayList<String>();
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	/*
	 * All the available windows will be stored in this method
	 */
	public void windowHandling(){
		Iterator<String> itr = getAllWindows();
		while(itr.hasNext()) {
			windowIds.add(itr.next());
		}
		driver.switchTo().window(windowIds.get(6));
		
		driver.switchTo().window(windowIds.get(4));
		
		driver.switchTo().window(windowIds.get(0));
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
