package com.gmail.test;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailTest {
	
	public static void main(String... args) throws Exception{
		String a="thallamsandeep@gmail.com",b="Thallambalaram";
		GmailTest objGmailTest = new GmailTest();
		objGmailTest.login(a,b);
	}
	
	public boolean isAlertPresent(WebDriver driver) 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	public void login(String userName, String password) throws Exception{
		System.setProperty("webdriver.chrome.driver","E:\\Personal\\Studies\\Testing\\Automation\\Java\\PracticeWorkspace\\PracticeSelProject1\\src\\com\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,15);
		
		//driver.get("http://www.tutorialspoint.com/selenium/"); //"https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm"
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Email']")));//.//*[@id='Passwd']
		driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(userName);
		driver.findElement(By.xpath(".//*[@id='next']")).click();////input[@id='next' AND @name='signIn']

		//input[@placeholder='Password' AND @type='password']
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='Passwd']")));//.//*[@id='Passwd']
		driver.findElement(By.id("Passwd")).click();
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@href='#inbox' and @title='Gmail']")));
		
		if (driver.findElement(By.xpath(".//*[@href='#inbox' and @title='Gmail']")).isDisplayed())
		{
			System.out.println("Success Login");
		}
		else
		{
			System.out.println("Login Fail as lOgo not appeared");
		}
		
/*		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else
		{
		    System.out.println("alert was present");
			String mainPage = driver.getWindowHandle();
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert text : " + alt.getText());
			alt.dismiss();
			driver.switchTo().window(mainPage);
		}
		*/
		if(isAlertPresent(driver))
		{
		    System.out.println("alert was present");
			String mainPage = driver.getWindowHandle();
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert text : " + alt.getText());
			alt.dismiss();
			driver.switchTo().window(mainPage);			
		}
		else
			System.out.println("No Alert Present");
		
		List<WebElement> colTR = driver.findElements(By.xpath("//div[@role='checkbox']/ancestor::tr"));//[".//div[text()='Primary']//following::table/tbody/tr"]
		System.out.println("Total Records : "+colTR.size());
		for (WebElement trElement : colTR)
		{
//			WebElement tdSpanElement = trElement.findElement(By.xpath("./td[5]//span"));
			WebElement tdCheckBox = trElement.findElement(By.xpath("./td[2]//*[@role='checkbox']"));
			tdCheckBox.click();
			System.out.println("Email from : "+ tdCheckBox.getAttribute("aria-checked"));
		}
	}//Main
	
	
	
}//Class
