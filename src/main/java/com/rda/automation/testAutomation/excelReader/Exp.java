package com.rda.automation.testAutomation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Exp {
	
		public static String text;
		static FileInputStream fis;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static int passResponseCount = 0;
		static int failResponseCount = 0;
		static float resultPercentage;
		//static String category = "broken";
		//static String path = "C:\\Users\\Madhu Veeranna\\Downloads\\Health\\BSD.xlsx";
		static String searchbroken = "broken";
		static String searchnonbroken = "nonbroken";  
		static String searchinvalid = "invalid";
		
		@Test
		@Parameters({"folderPath", "category"})
		public void readFolder(String folderPath, String category) throws IOException  {
			 File src = new File(folderPath);
			 fis = new FileInputStream(src);
			 workbook = new XSSFWorkbook(fis);
			 sheet = workbook.getSheetAt(0);
			 int rowcount = sheet.getLastRowNum();
			 System.out.println("total row is:- "+rowcount);
			 sheet.getRow(0).createCell(3).setCellValue("Result");
			 writeFile(folderPath);
			 for (int i = 1 ; i <= rowcount ; i++) {
				 XSSFRow rows = sheet.getRow(i);		 
				 XSSFCell cell = rows.getCell(2);
				 text = cell.getStringCellValue();
				 if(category.equalsIgnoreCase(searchbroken)){
					 broken(i,folderPath); 
				 } else if(category.equalsIgnoreCase(searchnonbroken)){
					 nonBroken(i,folderPath);
				 } else if(category.equalsIgnoreCase(searchinvalid)) {
					 invalid(i,folderPath);
			  	   } else {
			  		 System.out.println(" ################## Please provide valid category input from the XML FIle ie, BROKEN or NON-BROKEN or INVALID ##################");
				}
				 }
			 resultPercentage = (((float)passResponseCount * 100)/ rowcount);
		     String percentage = String.format("%.2f", resultPercentage);
		     System.out.println("Total number of uploaded images:- "+ rowcount);
		     System.out.println("Total number of images passed:- "+ passResponseCount);
		     System.out.println("Total number of images failed:- "+ failResponseCount);
		     System.out.println("Overall percentage of pass:- "+ percentage +"%");
		}
	
	public static void broken(int i, String folderPath) {
		if(text.equalsIgnoreCase("broken")){
			passResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Pass");
			 writeFile(folderPath);
		} else {
			failResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Fail");
			writeFile(folderPath);
			}
	}

	public static void nonBroken(int i, String folderPath) {
		if(text.equalsIgnoreCase("nonbroken")){
			passResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Pass");
			writeFile(folderPath);
		} else {
			failResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Fail");
			writeFile(folderPath);
			}
	}

	public static void invalid(int i, String folderPath) {
		if(text.equalsIgnoreCase("invalid")){
			passResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Pass");
			writeFile(folderPath);
		} else {
			failResponseCount++;
			sheet.getRow(i).createCell(3).setCellValue("Fail");
			writeFile(folderPath);
		 	}
	}
	
	public static void writeFile(String folderPath) {
		try {
			FileOutputStream fos = new FileOutputStream(folderPath);
			workbook.write(fos);
			//workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
