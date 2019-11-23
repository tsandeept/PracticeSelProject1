package com.indeed.getallimages;
import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GetAllImages {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		GetAllImages classobj = new GetAllImages(); 
		classobj.getImage(driver);
	}

public void getImage(WebDriver driver) throws Exception
{
File files = null;
int loop= 0;
driver.get("http://www.housingman.com");
Thread.sleep(5000);
List <WebElement> Images = driver.findElements(By.tagName("img"));
System.out.println("No_Of Images:" +Images.size());

for(WebElement img :Images)
{
if(img.isDisplayed())
{

// Get the all images name and display;

loop++;
Thread.sleep(3000);
String[] name = img.getAttribute("src").split("/");
String ImgName = name[name.length-1];
ImgName = ImgName.replace("?", "_");
System.out.println(ImgName);

// Save the all Images:

URL imag = new URL(img.getAttribute("src").trim());
files = new File("D:\\HousingMan\\"+ System.currentTimeMillis()+ "." +ImgName);

FileUtils.copyURLToFile(imag, files);
}
}
System.out.println("No_of Total downloaded images is :"+loop);
}
}