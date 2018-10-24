package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utils.TestUtils;

public class DealsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	TestUtils testutils;
	
	public DealsPageTest()	{
		super();
		System.out.println("DealsPageTest Constructor");}
	
@BeforeMethod
	public void setUp() {
		initialization();	
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutils = new TestUtils();
		testutils.switchToFrame();
		dealspage = homepage.clickOnDealsPageLink();
		
	}

@Test(priority=1)
	public void verifyHelpInfo() {
		boolean found=false;
		String dataTitle = dealspage.getLabelText();
		if (dataTitle.contains("You can use <strong>%</strong> as a wildcard</td>")) {
		    	found=true;
		}	
		Assert.assertTrue(found);
	}

@Test(priority=2)
	public void verifySavedSearches() {
		Assert.assertEquals(dealspage.savedSearches(), true);
	}

@Test(priority=3)
	public void verifySearch()	{
		dealspage.enterKeyword("Testing");
		dealspage.enableSaveSearch();
		testutils.copyScreenShot();
		dealspage.clickSearch();	
		Assert.assertEquals(dealspage.isSaveSearchEnabled(), true);
	}

@Test(priority=4)
	public void verifySearchResults()	{
		boolean found=false;
		dealspage.enterKeyword("Testing");
		dealspage.clickSearch();
		dealspage.enableSaveSearch();
		dealspage.enterSearchName("Test1");
		testutils.copyScreenShot();
		String searchData = dealspage.searchResults();
		if ((searchData.contains("10300")) && (searchData.contains("Testing")) && (searchData.contains("Mar 4, 2006")) && (searchData.contains("Naveen K"))) {
	    	found=true;
		}
		Assert.assertTrue(found);		 
}

@Test(priority=5)
	public void verifyDeleteSearch()	{
		dealspage.selectSavedSearch("Name this search");
		dealspage.clickDeleteSearch();
		testutils.copyScreenShot();
		driver.switchTo().alert().accept();
		Assert.assertTrue(dealspage.findSavedSearch("Name this search")); 
}

@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}