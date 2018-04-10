package com.rda.automation.testAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	//In order to read the data in Excel file we need a class, 
	//Creating all the below variables as Global Variable so that we can access the corresponding object from any method
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell column;
	
	//constructor of the class
	public Excel_Reader(String path){
		this.path = path;
		try {
			fis = new FileInputStream(path); 
			//Read the stream of data from excel file in one shot and when we are using anything of java classes we have to create the objects
			workbook = new XSSFWorkbook(fis); 
			//Once after we establish the connection with excel sheet we have to create the workbook object to access the data and pass the excel sheet path
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will return 2D object Data for each record in excel sheet 
	 * @param sheetName
	 * @param excelName
	 * @return 
	 */
	
	@SuppressWarnings("deprecation")
	public String[][] getDataFromSheet(String sheetName, String excelName){
		String dataSets[][] = null;
		try {
			//Get sheet from excel workbook
			 XSSFSheet sheet = workbook.getSheet(sheetName);
			//Count number of active rows containing record
			int totalRow= sheet.getLastRowNum() + 1;
			//Count number of column
			int totalColumn = sheet.getRow(0).getLastCellNum();
			//Create 2D array of rows and columns
			dataSets = new String [totalRow - 1][totalColumn];
			//Run for-loop and store data in 2D array
			//This for loop will run on rows and columns ie, i = Row, j = Column
			for (int i = 1; i < totalRow; i++) {
				XSSFRow rows = sheet.getRow(i);	
				//This for loop will run on the columns of above obtained rows, The second for loop will continue till all the columns data of that row are fetched
				for (int j = 0; j < totalColumn; j++) {
					//Get Cell method will get cell
					XSSFCell cell = rows.getCell(j);
					//Before storing the data we have to check the cell type and store the value
					//If cell type is string then this condition will work
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						//Since we are starting from row 1 will give it has [i-1]
						dataSets [i-1][j] = cell.getStringCellValue();
					}
					//If cell type is number then this condition will work
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getNumericCellValue());
						dataSets[i-1][j] = cellText;
					} 
					else
						//If cell type is boolean then this condition will work
						dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
			}
			return dataSets;
		} catch (Exception e) {
			System.out.println("Exception in reading Xlxs file" + e.getMessage());
			e.printStackTrace();
		}
		return dataSets;
	}
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName,int rowNum){
		
			try {
				int col_Num=0;
				int index = workbook.getSheetIndex(sheetName);
				sheet = workbook.getSheetAt(index);
				XSSFRow row = sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if(row.getCell(i).getStringCellValue().equals(colName)){
						col_Num = i;
						break; 
					}
				}
				row = sheet.getRow(rowNum - 1);

				XSSFCell cell = row.getCell(col_Num);
				if(cell.getCellType() == Cell.CELL_TYPE_STRING){
					return cell.getStringCellValue();
				} else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
					return "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return null;
		
	}
		
	 
}
