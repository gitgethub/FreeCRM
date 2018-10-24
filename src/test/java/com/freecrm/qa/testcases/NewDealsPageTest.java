package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.NewDealsPage;
import com.freecrm.qa.utils.TestUtils;

public class NewDealsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	NewDealsPage newdealspage;
	
	public NewDealsPageTest() {
		super();
		System.out.println("NewDealsPageTest Constructor");
	}
	
	@BeforeMethod
	public void setUp()	{
		initialization();
		testutils = new TestUtils();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutils.switchToFrame();
		newdealspage = homepage.clickOnNewDealLink();
	}
	
	@Test (priority=1, enabled=false)
	public void verifyLabelsDisplayed() {
		boolean displayed=false;
		if (newdealspage.pageHeaderLabelDisplayed() && newdealspage.labelAmountDisplayed() && newdealspage.labelCompanyDisplayed()
				&&newdealspage.labelDealNoDisplayed()  && newdealspage.labelPrimaryContactDisplayed() && 
				newdealspage.labelTitleDisplayed()) {
			displayed = true;	}	
		Assert.assertTrue(displayed);
		testutils.copyScreenShot();
	}
	
	@Test (priority=2, enabled=false)
	public void verifyAddingNewDeal()	{
		newdealspage.enterCompanyName("Lyft");
		newdealspage.clickCompanyLookupLink();
		testutils.switchToCompanyLookup();
		Assert.assertEquals(newdealspage.getCompanyLookupTitle(), "CRMPRO - Company lookup");
	}
	
	@Test (priority=3, enabled=false)
	public void verifyPopulatingCompany() 	{
		newdealspage.clickCompanyLookupLink();
		testutils.switchToCompanyLookup();
		newdealspage.enterSearchText("Amazon");
		newdealspage.clickSearchButton();
		newdealspage.clickOnSearchResultLink();
		testutils.switchToCompanyLookup();
		Assert.assertEquals(driver.getTitle(),"CRMPRO");
	}
	
	@Test (priority=4)
	public void verifyPopulatingContact() throws InterruptedException  	{
		int startDealNo;
		startDealNo = newdealspage.getDealNoSequence();
		newdealspage.clickContactLookupLink();
		testutils.switchToCompanyLookup();
		Assert.assertEquals(newdealspage.getContactLookupTitle(), "CRMPRO - Contact lookup");
		newdealspage.enterContactSearchText("Tom Peter");
		newdealspage.clickContactSearchButton();
		newdealspage.clickOnContactSearchResultLink();
		testutils.switchToCompanyLookup();
		Assert.assertEquals(driver.getTitle(),"CRMPRO");
		testutils.switchToFrame();
		newdealspage.enterTitleText("Mr.");
		newdealspage.enterAmountValue(150);
		newdealspage.selectProduct("shoes");
		newdealspage.enterProbabilityPercentage(15);
		newdealspage.enterCommissionPercentage(30);
		newdealspage.enableExcludeFromReports();
		newdealspage.selectSource("Word of Mouth");
		newdealspage.enableStatusClosed();
		testutils.copyScreenShot();
		newdealspage.clickSaveandCreateAnother();

		Assert.assertEquals(startDealNo+1, newdealspage.getDealNoSequence());

	}
	
	@AfterMethod
	public void tearDown() 	{
		driver.quit();
	}
}

