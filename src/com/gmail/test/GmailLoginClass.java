package com.gmail.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GmailLoginClass extends DriverHome{
	boolean blnSuccessLogin;
	//static WebDriver driver;
	
	public GmailLoginClass(){
		PageFactory.initElements(driverHome, this);
	}
	
	@FindBy(xpath = ".//*[@id='Email']")
	public WebElement userNameTextBox;
	
	@FindBy(xpath = ".//*[@id='next']")
	public WebElement nextbtn;
	
	@FindBy(id = "Passwd")
	public WebElement passwrdTextbox;

	@FindBy(xpath = ".//*[@id='signIn']")
	public WebElement signInbtn;
	
	@FindBy(xpath = ".//*[@href='#inbox' and @title='Gmail']")
	public WebElement gmailLogo;
	
	public void login(WebDriver driver,String userName, String password) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,15);
		
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#");//https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1
		wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
		userNameTextBox.sendKeys(userName);
		nextbtn.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(passwrdTextbox));
		passwrdTextbox.click();
		passwrdTextbox.sendKeys(password);
		signInbtn.click();
		wait.until(ExpectedConditions.visibilityOf(gmailLogo));
		
		if (gmailLogo.isDisplayed())
		{
			System.out.println("Success Login");
		}
		else
		{
			System.out.println("Login Fail as lOgo not appeared");
		}

		
		//driver.close();
 }
	@Test
	public void loginTest() throws Exception
	{
		//GmailLoginClass.driver = DriverHome.driverHome;
		GmailLoginClass objGmailLoginClass = new GmailLoginClass();
		objGmailLoginClass.login(driverHome, "thallamsandeep@gmail.com", "Thallambalaram");
	}
 
}
