package com.freecrm.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utils.TestUtils;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtils testutils;
	
	public ContactsPageTest() {
		super();
		System.out.println("ContactsPageTest Constructor");	
	}
	
	
	@BeforeMethod
	public void setUp()	{
		initialization();
		testutils = new TestUtils();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutils.switchToFrame();
		contactspage = homepage.clickOnContactsPageLink();
		
	}
	
	@Test(priority=1)
	public void contactsLabelIsDisplayedTest() {
		Assert.assertEquals(true, contactspage.verifyContactsLabelIsDisplayed());
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactspage.selectContacts();
		Assert.assertTrue(contactspage.isContactSelected());
		testutils.copyScreenShot();
	}
	
	@Test(priority=3)
	public void selectContactsByNameTest() {
		contactspage.selectContactsByName("Akshay Kumar");
		Assert.assertTrue(contactspage.isContactSelectedAR());
		testutils.copyScreenShot();
	}
	
	//threadPoolSize = 3, invocationCount = 10,  timeOut = 10000
	@Test(priority=4)
	public void selectMultipleContactsByNameTest() {
		contactspage.selectContactsByName("Agnimitra Paul");
		contactspage.selectContactsByName("ACHALA KUMARI");
		Assert.assertTrue(contactspage.isContactSelectedAgnimitraPaul());
		Assert.assertTrue(contactspage.isContactSelectedACHALAKUMARI());
		testutils.copyScreenShot();
	}

	@Test(priority=5)
	public void verifyNewlyAddedContactLinkIsDisplayed()	{
	Assert.assertTrue(contactspage.contactLinkDisplayed());
	List<WebElement> lists = contactspage.countOfImages();
	for (WebElement l: lists)	{
		System.out.println(l.getAttribute("src").toString());
	}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

