package com.Selenium.MulitpleWindow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.utilityfiles.mtds.Resuable_Mtds;

public class MultipleWindow_Handling extends Resuable_Mtds {

	public static WebDriver driver;


	public static void main(String[] args) throws Exception {
		
		driver = browser_Configure("chrome");
		//System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		implicity_Wait(10);
		driver.get("https://www.amazon.com/");

		WebElement sub_Btn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
		sub_Btn.click();
		WebElement deals = driver.findElement(By.xpath("(//a[contains(.,'Deals')])[1]"));
		right_CLick(driver, deals);
		down_And_Enter();
		WebElement gift = driver.findElement(By.xpath("//a[.='Gift Cards']"));
		right_CLick(driver, gift);
		down_And_Enter();
		WebElement registry = driver.findElement(By.xpath("//a[.='Registry']"));
		right_CLick(driver, registry);
		down_And_Enter();
		
		//Multiple Window Handling
		Set<String> all_Id = driver.getWindowHandles();// 1,2,3,4
		String excepted_Url = "https://www.amazon.com/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc";
		for (String id : all_Id) {
			if (driver.switchTo().window(id).getCurrentUrl().equals(excepted_Url)) {
				System.out.println(driver.getTitle());
			}

		}
	}
}