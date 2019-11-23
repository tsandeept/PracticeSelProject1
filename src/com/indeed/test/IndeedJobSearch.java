package com.indeed.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;//////

public class IndeedJobSearch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver","E:\\Personal\\Studies\\Testing\\Automation\\Selenium\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();*/
		/*		System.setProperty("webdriver.ie.driver","E:\\Personal\\Studies\\Testing\\Automation\\Selenium\\IEDriverServer.exe");		
		WebDriver driver = new InternetExplorerDriver();*/
		//Create firefox driver to drive test
		System.setProperty("webdriver.gecko.driver", "E:\\Personal\\Studies\\Testing\\Automation\\Java\\PracticeWorkspace\\PracticeSelProject1\\src\\com\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// Implicit Wait: At Driver Level, more or less like a global wait.
 		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open indeed home page
		driver.get("https://www.indeed.co.uk");
		
		/*Explicit Wait: At object level.
 		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("what")));*/
		
	    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(60, TimeUnit.SECONDS)
	            .pollingEvery(10, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("what")));
	    /*FluentWait fluentWait = new FluentWait(driver);
			Wait wait = fluentWait
	       .withTimeout(30, SECONDS)
	       .pollingEvery(5, SECONDS)
	       .ignoring(NoSuchElementException.class);*/
		driver.findElement(By.id("what")).sendKeys("Selenium");
		//Thread.sleep(2000);
		
		//fine what field and eneter selinium in it.
		//find where firld and enetering location
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("London");
		//find job serach button
		driver.findElement(By.id("fj")).click();		
		//find job tittle		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		// find jobs count value
		driver.close();
		
		/*GetAllImages a = new GetAllImages();
		a.getImage(driver);*/

	}



}
