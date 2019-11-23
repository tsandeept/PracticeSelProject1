package com.gmail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class DriverHome {

	public static WebDriver driverHome;
	
	/*public DriverHome()
	{*/
		@BeforeSuite
		public WebDriver driverInitinalization()
		{
			System.setProperty("webdriver.chrome.driver","E:\\Personal\\Studies\\Testing\\Automation\\Java\\PracticeWorkspace\\PracticeSelProject1\\src\\com\\resources\\chromedriver.exe");
			driverHome = new ChromeDriver();
			return driverHome;
		}

		
	//}
	
	
	
	
}
