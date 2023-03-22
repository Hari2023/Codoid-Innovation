package com.Selenium.ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData_ExcelUtility {

	public static Sheet sheet;
	public static Row row;
	public static int lastRowNum;
	public static String locatorColumnValue;
	public static String locatorName;
	public static String locatorValue;
	public static String keywordColumnValue;
	public static String dataColumnValue;

	public void readFromExcel(String location) throws Exception {

		File f = new File(location);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");

		lastRowNum = sheet.getLastRowNum();

	}

	public void getValuefromexcel(int row, int locatorColumn, int keywordColumn, int dataColumn) {

		locatorColumnValue = sheet.getRow(row).getCell(locatorColumn).toString().trim();

		
		if (!locatorColumnValue.contains("NA")) {
			locatorName = locatorColumnValue.split("=")[0].toString().trim();
			locatorValue = locatorColumnValue.split("=")[1].toString().trim();

		} else {
			locatorName = "NA";
			locatorValue = "NA";
		}

		

		 keywordColumnValue = sheet.getRow(row).getCell(keywordColumn).toString().trim();
		dataColumnValue = sheet.getRow(row).getCell(dataColumn).toString().trim();
		System.out.println(locatorName+"  :   "+     locatorValue +    "Keyword    :    "  + keywordColumnValue + "Data:    " +
		dataColumnValue);
		
	}

}
