package com.Selenium.ReadData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import dev.failsafe.internal.util.Durations;

public class ActionKeywords {

	static WebDriver driver;

	// open browser

	public static void openBrowser() {
		if (ReadData_ExcelUtility.dataColumnValue.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origin");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\CodoidInnovation\\Driver\\chromedriver.exe");

			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}

	}

	public static void launchURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	public static void enterUsername() {

		WebElement username = driver.findElement(Run_Engine.locator);
		username.sendKeys(ReadData_ExcelUtility.dataColumnValue);
	}

	public static void enterPassword() {
		WebElement passwd = driver.findElement(Run_Engine.locator);
		passwd.sendKeys(ReadData_ExcelUtility.dataColumnValue);
	}

	public static void click() {
		WebElement submit = driver.findElement(Run_Engine.locator);
		submit.click();
	}
}
