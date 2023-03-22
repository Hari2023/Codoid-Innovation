package com.Selenium.ReadData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

public class Run_Engine {
	 ActionKeywords actionkeywords;
	 Method[] methods;
	public static By locator;

	public Run_Engine() {

		actionkeywords = new ActionKeywords();
		methods = actionkeywords.getClass().getMethods();

	}

	public void executeKeywords() throws Exception {

		for (int i = 0; i<methods.length ; i++) {
			if (methods[i].getName().equalsIgnoreCase(ReadData_ExcelUtility.keywordColumnValue)) {
				methods[i].invoke(actionkeywords);
				break;
			}

		}
	}

	public void findElementToBeUsed() {

		switch (ReadData_ExcelUtility.locatorName) {
		case "id":
			locator = Locators.getId(ReadData_ExcelUtility.locatorValue);

			break;
		case "name":
			locator = Locators.getName(ReadData_ExcelUtility.locatorValue);

			break;
		case "tagName":
			locator= Locators.getTagName(ReadData_ExcelUtility.locatorValue);

			break;

		default:
			break;
		}
	}

	public static void main(String[] args) throws Exception {

		ReadData_ExcelUtility utilities = new ReadData_ExcelUtility();

		utilities.readFromExcel("C:\\Users\\ELCOT\\eclipse-workspace\\CodoidInnovation\\TestData.xlsx");
		int locatorColumn = 3;
		int keywordColumn = locatorColumn + 1;
		int dataColumn = locatorColumn + 2;

		Run_Engine engine = new Run_Engine();

		for (int row = 1; row <= ReadData_ExcelUtility.lastRowNum; row++) {
			
			utilities.getValuefromexcel(row, locatorColumn, keywordColumn, dataColumn);
			
			engine.findElementToBeUsed();
		    engine.executeKeywords();

		}

	}

}
