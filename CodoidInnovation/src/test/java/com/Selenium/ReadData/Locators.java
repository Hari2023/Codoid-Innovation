package com.Selenium.ReadData;

import org.openqa.selenium.By;

public class Locators {

	public static By getId(String locatorValue) {
		return By.id(locatorValue);

	}

	public static By getName(String locatorValue) {

		return By.name(locatorValue);
	}

	public static By getTagName(String locatorValue) {
		return By.tagName(locatorValue);
	}

}
