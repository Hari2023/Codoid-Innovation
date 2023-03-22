package com.utilityfiles.mtds;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Resuable_Mtds {

	public static WebDriver driver;

	public static WebDriver browser_Configure(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\CodoidInnovation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\ELCOT\\ecl" + "ipse-workspace\\Oct31_Proj\\Driver\\msedgedriver1.exe");

		}
		return driver;

	}

	public static WebDriver switch_Browser(String browser) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Oct31_Proj\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Oct31_Proj\\Driver\\chromedriver.exe");
			driver = new EdgeDriver();
			break;

		}
		return driver;
	}

	public static void get_Url(String Value) {

		driver.get(Value);

	}

	public static void implicity_Wait(long value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}

	public static void window_Commands(String Commands) {

		if (Commands.equalsIgnoreCase("maximize")) {
			driver.manage().window().maximize();

		} else if (Commands.equalsIgnoreCase("minimize")) {
			driver.manage().window().minimize();
		}

		else if (Commands.equalsIgnoreCase("deleteAllcookies")) {
			driver.manage().deleteAllCookies();

		}

	}

	public static void click_On_Element(WebElement element) {
		element.click();

	}

	public static void send_Keys(WebElement element, String Values) {

		element.sendKeys(Values);

	}

	public static void clear(WebElement element) {
		element.clear();

	}

	public static void move_To_Element(WebElement element) {

		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}

	public static void click_fun(WebElement element) {

		Actions b = new Actions(driver);
		b.click(element).build().perform();

	}

	public static void select_By_Value(WebElement element, String Value) {

		Select d = new Select(element);
		d.selectByValue(Value);

	}

	public static void select_Visible_Text(WebElement element, String data) {
		Select b = new Select(element);
		b.selectByVisibleText(data);

	}

	public static void select_By_Index(WebElement element, int value) {

		Select s = new Select(element);
		s.selectByIndex(value);

	}

	public static String get_Text(WebElement element) {

		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public static void screen_Shot(WebElement element) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Test_Prgm\\ScreenShot\\element.png");
        FileUtils.copyFile(src, des);
	}

	public static void java_Script(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		js.executeScript("arguments[0].click()", element);
	}

	public static void sleep(long value) throws InterruptedException {

		Thread.sleep(value);
	}

	public static void frame(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void frame_Defau(WebElement element) {
		driver.switchTo().defaultContent();
	}
	
	public static void right_CLick(WebDriver d, WebElement element) {
		Actions a = new Actions(d);
		a.contextClick(element).build().perform();
	}

	public static void down_And_Enter() throws AWTException {

		Robot s = new Robot();
		s.keyPress(KeyEvent.VK_DOWN);
		s.keyRelease(KeyEvent.VK_DOWN);
		s.keyPress(KeyEvent.VK_ENTER);
		s.keyRelease(KeyEvent.VK_ENTER);
	}


	

	

}
