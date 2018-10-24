package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.NewContactPage;
import com.freecrm.qa.utils.TestUtils;

public class NewContactPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtils testutils;
	NewContactPage newcontactpage;
	
	String sheetName = "contacts";
	
	public NewContactPageTest() {
		super();
		System.out.println("NewContactPageTest Constructor");	
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutils = new TestUtils();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutils.switchToFrame();
		newcontactpage = homepage.clickOnNewContactLink();
	}
	
	@Test(priority=1) 
		public void verifyLabelContactInformationDisplayed() {
			Assert.assertTrue(newcontactpage.labelContactInformationDisplayed());
		}
	
	@Test(priority=2) 
	public void verifyLabelAddressDisplayed() {
		Assert.assertTrue(newcontactpage.labelAddressDisplayed());
	}
	
	@Test(priority=3) 
	public void verifyLabelNotesDescriptionDisplayed() {
		Assert.assertTrue(newcontactpage.labelNotesDescriptionDisplayed());
	}
	
	@DataProvider
	public Object[][] getCRMData()	{
		Object[][] testInput = testutils.getCRMTestData(sheetName);
		return testInput;
	}
	
	@Test(priority=4, dataProvider="getCRMData")
	public void verifySaveNewContact(String title, String fname, String sname, String hphone) {
		newcontactpage.saveNewContact(title, fname, sname, hphone);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}


