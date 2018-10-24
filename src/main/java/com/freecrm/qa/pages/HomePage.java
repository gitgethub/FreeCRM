package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[@class='headertext' and @align='left']")
	WebElement loggedInUser;
	
	@FindBy(css="#navmenu > ul > li:nth-child(4) > a")
	WebElement linkContacts;
	
	@FindBy(css="#navmenu > ul > li:nth-child(5) > a")
	WebElement linkDeals;
	
	@FindBy(xpath="a[contains(text(), 'Tasks')]")
	WebElement linkTasks;
	
	@FindBy(xpath="//a[@title='New Contact']")	
	WebElement linkNewContact;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement linkNewDeal;
	
	public HomePage()	{
		PageFactory.initElements(driver, this);
		System.out.println("HomePage Constructor");
	}
	
	public String getHomePageTitle()	{
		return driver.getTitle();
	}
	
	public String getLoggedInUsername()	{
		return loggedInUser.getText();
	}
	
	public ContactsPage clickOnContactsPageLink()	{
		linkContacts.click();
		return new ContactsPage() ;	
	}
	
	public NewContactPage clickOnNewContactLink()	{
		Actions actions = new Actions(driver);
		actions.moveToElement(linkContacts).build().perform();
		linkNewContact.click();
		return new NewContactPage() ;	
	}
	
	public DealsPage clickOnDealsPageLink()	{
		linkDeals.click();
		return new DealsPage() ;
	}
	
	public TasksPage clickOnTasksPageLink()	{
		linkTasks.click();
		return new TasksPage() ;
	}
	
	public NewDealsPage clickOnNewDealLink()	{
		Actions actions = new Actions(driver);
		actions.moveToElement(linkDeals).build().perform();
		linkNewDeal.click();
		return new NewDealsPage() ;
	}
}