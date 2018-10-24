package com.freecrm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
/*	@FindBy(xpath="//a[contains(text(),'Akshay Kumar')]")
	WebElement contactLink; */
			
	public boolean verifyContactsLabelIsDisplayed() {
		return contactsLabel.isDisplayed();
	}
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectContacts() {
		//driver.findElement(By.xpath("//a[contains(text(),'Akshay Kumar')]")).click();
		driver.findElement(By.xpath("//a[text()='Akshay Kumar']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}
	
	public boolean isContactSelected()	{
		return driver.findElement(By.xpath("//a[text()='Akshay Kumar']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).isEnabled();
	}
	
	public boolean isContactSelectedAR() {
		WebElement contactLinkAR = driver.findElement(By.xpath("//a[text()='ACHALA KUMARI']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		return contactLinkAR.isEnabled();
	}
	
	public boolean isContactSelectedAgnimitraPaul() {
		WebElement contactLinkAL = driver.findElement(By.xpath("//a[text()='Agnimitra Paul']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		return contactLinkAL.isEnabled();
	}
	
	public boolean isContactSelectedACHALAKUMARI() {
			return driver.findElement(By.xpath("//a[contains(text(),'ACHALA KUMARI')]")).isEnabled();
	}
	
	public boolean contactLinkDisplayed() {
		return driver.findElement(By.xpath("//a[contains(text(),'Akshay Kumar')]")).isDisplayed();
	}
	
	public List <WebElement> countOfImages()	{
		List <WebElement> list = driver.findElements(By.tagName("img"));
		return list;
		
	}
}
