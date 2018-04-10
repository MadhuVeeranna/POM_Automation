package com.rda.automation.testAutomation.homepage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample{
	
	//This test method declares that its data should be supplied by the Data Provider
	//"getdata" is the function name which is passing the data
    //Number of columns should match the number of input parameters
	@Test(dataProvider="getData")
	public void setData(String username, String password)
	{
		System.out.println("you have provided username as::"+username);
		//System.out.println("you have provided password as::"+password);
	}

	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
		Object[][] data = new Object[3][2];
		
		//1st row
		data[0][0] ="Madhu";
		data[0][1] = "hello1";		
		//2nd row
		data[1][0] = "Madhu1";
		data[1][1] = "hello12";
		
		//3rd row
		data[2][0] = "Madhu2";
		data[2][1] = "hello123";
		
		return data;
		
	}
}
