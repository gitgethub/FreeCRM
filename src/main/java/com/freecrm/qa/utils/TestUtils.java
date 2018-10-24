package com.freecrm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.qa.base.TestBase;

public class TestUtils extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_FILENAME_LOC = "/Users/mymbp/Documents/workspace/FreeCRM/src/main/java/com/crm/qa/testdata/CRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public void switchToIFrame() {
		driver.switchTo().frame("iframe");
	}
	
	public void switchToCompanyLookup() {
		 for (String handle : driver.getWindowHandles()) { 
			    driver.switchTo().window(handle);}
	}
	
	public void copyScreenShot() {
		String capture;
		Random number = new Random();
		int pickedNumber = number.nextInt(100) + 1;
		capture = "window"+pickedNumber+".png";
		try{	
			
			Thread.sleep(3000);

	        byte screenshot[] = (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

	        FileOutputStream fos = new FileOutputStream(capture);
	        fos.write(screenshot);	
	        fos.close();
		}
		catch (Exception e){
			System.out.println(e);
							}

		}
	
	public Object[][] getCRMTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_FILENAME_LOC);
		}
		catch (FileNotFoundException e)	{
			e.printStackTrace();	}
		try {
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e)	{
			e.printStackTrace();	}
		catch (IOException e)	{
			e.printStackTrace();	}
		sheet = book.getSheet(sheetName);
		Object [][] cellData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0; i < sheet.getLastRowNum(); i++ ) {
			for (int j=0; j < sheet.getRow(0).getLastCellNum(); j++) {
				cellData[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return cellData;
	}
}

