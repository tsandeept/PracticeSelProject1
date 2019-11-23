package com.gmail.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	//This test method declares that its data should be supplied by the Data Provider
	// "getdata" is the function name which is passing the data
       // Number of columns should match the number of input parameters
	@Test(dataProvider="getData")
	public void setData(String username, String password)//
	{
		System.out.println("you have provided username as::"+username);
		System.out.println("you have provided password as::"+password);
	}

	@DataProvider
	public Object[][] getData() throws IOException,FileNotFoundException
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="sampleuser1";
	data[0][1] = "abcdef";

	// 2nd row
	data[1][0] ="testuser2";
	data[1][1] = "zxcvb";
	
	// 3rd row
	data[2][0] ="guestuser3";
	data[2][1] = "pass123";
	
	//FileOutputStream fos = new FileOutputStream("E:\\Personal\\Studies\\Testing\\Automation\\Java\\PracticeWorkspace\\PracticeSelProject1\\src\\com\\gmail\\GmailTestData.xlsx");
	File xlSrc = new File ("E:\\Personal\\Studies\\Testing\\Automation\\Java\\PracticeWorkspace\\PracticeSelProject1\\src\\com\\gmail\\GmailTestData.xlsx");
	FileInputStream fis = new FileInputStream(xlSrc);
	XSSFWorkbook objwrkbk = new XSSFWorkbook(fis);
	XSSFSheet objSheet = objwrkbk.getSheet("Sheet1");
	//new String[][];
	int NoRows = objSheet.getPhysicalNumberOfRows();
	String[][] arrArray = new String[NoRows][NoRows];//null;
	int intColumnCount;
	XSSFRow objRow;XSSFCell objCell;
	for(int itr=0;itr<NoRows;itr++)
		{
			objRow = objSheet.getRow(itr);
			intColumnCount = objRow.getLastCellNum();
			for(int itc=0;itc<intColumnCount;itc++)
			{
				objCell = objRow.getCell(itc);
				arrArray[itr][itc] = objCell.getStringCellValue();
				System.out.println(arrArray[itr][itc]);
			}
		}
/*	arrArray[0][0] = "Sandeep00";
	arrArray[0][1] = "SandeepPassword01";
	arrArray[1][0] = "Sandeep10";
	arrArray[1][1] = "Sandeep11";*/
	return arrArray; 
	}
}





	



