package com.rda.automation.testAutomation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
		public static String text;
		static FileInputStream fis;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static int passResponseCount = 0;
		static int failResponseCount = 0;
		static float resultPercentage;
		static String category = "broken";
		static String path = "C:\\Users\\Madhu Veeranna\\Downloads\\Health\\BSD.xlsx";
		//static int a = 1;
		
	public static void main(String[] args) throws IOException {

		 File src = new File(path);
		 fis = new FileInputStream(src);
		 workbook = new XSSFWorkbook(fis);
		 sheet = workbook.getSheetAt(0);
		 int rowcount = sheet.getLastRowNum();
		 System.out.println("total row is:- "+rowcount);
		 sheet.getRow(0).createCell(3).setCellValue("Result");
		 writeFile();
		 for (int i = 1 ; i <= rowcount ; i++) {
			 
			 XSSFRow rows = sheet.getRow(i);		 
			 XSSFCell cell = rows.getCell(2);
			 text = cell.getStringCellValue();
			 
			if(text.equalsIgnoreCase(category)){
			 sheet.getRow(i).createCell(3).setCellValue("Pass");
			 writeFile();
	     	 } else {
			 sheet.getRow(i).createCell(3).setCellValue("Fail");
			 writeFile();
		     }

			 /*if(text.equalsIgnoreCase(category)){
				 broken(); 
			 } else if(text.equalsIgnoreCase(category)){
				 nonBroken();
			 } else {
				 invalid();
			 }*/
		 }
		 resultPercentage = (((float)passResponseCount * 100)/ rowcount);
	     String percentage = String.format("%.2f", resultPercentage);
	     System.out.println("Total number of uploaded images:- "+ rowcount);
	     System.out.println("Total number of images passed:- "+ passResponseCount);
	     System.out.println("Total number of images failed:- "+ failResponseCount);
	     System.out.println("Overall percentage of pass:- "+ percentage +"%");
	}

	public static void broken() {
		if(text.equalsIgnoreCase("broken")){
			passResponseCount++;
		} else {
			failResponseCount++;
			}
	}

	public static void nonBroken() {
		if(text.equalsIgnoreCase("nonbroken")){
			passResponseCount++;
		} else {
			failResponseCount++;
			}
	}

	public static void invalid() {
		if(text.equalsIgnoreCase("invalid")){
			passResponseCount++;
		} else {
			failResponseCount++;
		 	}
	}
	
	public static void writeFile() {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			//workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
