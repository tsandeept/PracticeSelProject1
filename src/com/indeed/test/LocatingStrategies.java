package com.indeed.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingStrategies {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create firefox driver to drive test
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//open indeed home page
		driver.get("http://www.indeed.co.uk");
		
		//Locating by ID
		driver.findElement(By.id("what")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		//Locating by Name
		driver.findElement(By.name("l")).clear();
		driver.findElement(By.name("l")).sendKeys("London");
		
		
		
		List<WebElement> colobject = driver.findElements(By.tagName("input"));
		colobject.get(1).clear();
		colobject.get(1).sendKeys("Bristol");
		////Locating by Css
		System.out.println(
				driver.findElement(By.cssSelector("input.input_submit"))
				.getAttribute("value")
		);
		driver.findElement(By.cssSelector("input.input_submit")).click();
//		driver.findElement(By.xpath(""));
		
		//find job tittle
		System.out.println(driver.getTitle());
		
		// find jobs count value
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		
		//driver.close();

	}

}
