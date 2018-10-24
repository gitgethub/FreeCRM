package com.freecrm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class NewContactPage extends TestBase {

	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="body > table:nth-child(5) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > fieldset > legend")
	WebElement labelContactInformation;
	
	@FindBy(css="#contactForm > table > tbody > tr:nth-child(3) > td > fieldset > legend")
	WebElement labelAddress;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[6]/td/strong")
	WebElement labelNotesDescription;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleField;
	
	@FindBy(xpath="//*[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id='surname']")
	WebElement surName;
	
	@FindBy(xpath="//*[@id='home_phone']")
	WebElement homePhone;
	
	public boolean labelContactInformationDisplayed() {
		return labelContactInformation.isDisplayed();
	}
	
	public boolean labelAddressDisplayed() {
		return labelAddress.isDisplayed();
	}
	
	public boolean labelNotesDescriptionDisplayed() {
		return labelNotesDescription.isDisplayed();
	}
	
	public void saveNewContact (String title, String fname, String sname, String hphone)	{
		Select select = new Select(titleField);
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		surName.sendKeys(sname);
		homePhone.sendKeys(hphone);
		driver.findElement(By.xpath("//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")).click();
	}
	
	
}

