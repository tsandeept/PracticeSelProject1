package com.gmail.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailComposeMessage extends DriverHome {
//	static WebDriver driver;
	public GmailComposeMessage(){
		PageFactory.initElements(DriverHome.driverHome, this);
	}
	
	@FindBy(xpath = "//div[text()='COMPOSE']")
	public WebElement composebtn;
	
	@FindBy(xpath = "//div[@class = 'aYF' and text()='New Message']")
	public WebElement newMessageText;
	
	@FindBy(xpath = "//img[@alt = 'Close']")
	public WebElement closeBtn;

	@FindBy(xpath = "//div[@aria-label = 'Message Body' and @role='textbox' ]")
	public WebElement messagebodyTextbox;
	
	@Test
	public void composeMail()
	{
		//GmailComposeMessage.driver = DriverHome.driverHome;
		new GmailComposeMessage();
		composebtn.click();
		if(newMessageText.isDisplayed())
		{
			System.out.println("New Message popup displayed");
			messagebodyTextbox.sendKeys("Selenium Automated message");
			closeBtn.click();
		}
		else
		{
			System.out.println("New Message Box not displayed");
		}
		
	}
}
