package com.gmail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DraftmessagePage extends DriverHome{
	static WebDriver driver;
	public DraftmessagePage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//a[contains(text(),'Drafts')]")
	public WebElement draftslink;
	
	@Test
	public void draftMessages()
	{
		DraftmessagePage.driver = DriverHome.driverHome;
		//new DraftmessagePage();
		draftslink.click();
		System.out.println("Clicked on Drafts Link");
	}
}
