package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utils.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	TestUtils tu;
	ContactsPage cp;
	
	public HomePageTest()	{
		super();	
		System.out.println("HomePageTest Constructor");
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		tu = new TestUtils();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String hPageTitle = hp.getHomePageTitle();
		Assert.assertEquals(hPageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyLoggedInUsername()	{
		tu.switchToFrame();
		String loggedInUsername = hp.getLoggedInUsername();
		Assert.assertEquals(loggedInUsername, "  User: Naveen K");
	}
	
	@Test(priority=3)
	public void verifyContactsPageLink() {
		tu.switchToFrame();
		cp = hp.clickOnContactsPageLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

