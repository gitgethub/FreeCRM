package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait some_element;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/mymbp/Documents/workspace/TestGoogleCalculator/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);

			} catch (FileNotFoundException e)	{
				e.printStackTrace();
			} catch (IOException e)	{
				e.printStackTrace();
			}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))	{
			System.setProperty("webdriver.chrome.driver","/Users/mymbp/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF"))	{
			System.setProperty("webdriver.gecko.driver","/Users/mymbp/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//some_element = new WebDriverWait(driver,100); 
		
		String homePageURL = prop.getProperty("url");
		driver.get(homePageURL);
	}

	
}

