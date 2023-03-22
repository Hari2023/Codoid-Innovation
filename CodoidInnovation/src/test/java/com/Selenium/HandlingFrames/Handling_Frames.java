package com.Selenium.HandlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilityfiles.mtds.Resuable_Mtds;

public class Handling_Frames extends Resuable_Mtds {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = browser_Configure("chrome");

		get_Url("https://demo.automationtesting.in/Frames.html");

		driver.manage().window().maximize();

		implicity_Wait(10);

		driver.switchTo().frame("singleframe");
		WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
		text.sendKeys("Hari");

		driver.switchTo().defaultContent();

		WebElement Iframe = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		Iframe.click();

		WebElement outer_frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));

		driver.switchTo().frame(outer_frame);

		WebElement frame_two = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(frame_two);

		WebElement text_two = driver.findElement(By.xpath("//input[@type='text']"));
		text_two.sendKeys("Baskar");

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		WebElement singleframe = driver.findElement(By.xpath("//a[text()='Single Iframe ']"));
		singleframe.click();

	}

}
