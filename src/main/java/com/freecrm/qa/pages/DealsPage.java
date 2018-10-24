package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class DealsPage extends TestBase{

	public DealsPage()	{
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//input[@type='text' and @name='cs_keyword']")
	WebElement searchKeyword;

	@FindBy(xpath="//td[text()='Saved Searches']")
	WebElement savedSearches;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='cs_save_search']")
	WebElement saveSearch;

	@FindBy(xpath="//input[@class='button' and @type='submit' and @name='cs_submit']")
	WebElement btnSearch;

	@FindBy(xpath="//*[@id='cs_search_title']/input")
	WebElement nameThisSearch;
	
	@FindBy(xpath="//select[@name='cs_saved_search_id']")
	WebElement savedSearch;
	
	@FindBy(xpath="//input[@name='del_search']")
	WebElement deleteSearch;
	
	public void clickDeleteSearch()	{
		deleteSearch.click();
	}
		
	public void selectSavedSearch(String text) {
		Select select = new Select(savedSearch);
		select.selectByVisibleText(text);
	}
	
	public boolean findSavedSearch(String text) {
		boolean found=true;
		try {
			Select select = new Select(savedSearch);
			select.selectByVisibleText(text);
			found = true;
			}
		catch (Exception e)	{
			found = false;
		}
		return found;	
	}
	
	public void enterSearchName(String name) {
		nameThisSearch.sendKeys(name);
	}

	public void enterKeyword(String keyword)	{
		searchKeyword.sendKeys(keyword);
	}
	
	public boolean savedSearches()	{
		return savedSearches.isDisplayed();
	}
	
	public void enableSaveSearch()	{
		saveSearch.click();
	}
	
	public boolean isSaveSearchEnabled()	{
		return saveSearch.isEnabled();
	}
		
	public void clickSearch()	{
		btnSearch.click();
	}
	
	public String getLabelText() {
		//*[@id='extendedSearchLayer']/table/tbody/tr[1]/td/text()[2]		
		String dataTitle = driver.findElement(By.xpath("//td[contains(@class,'datatitle')]")).getAttribute("outerHTML");
		return dataTitle;
		}
		
	public String searchResults() {
		String searchData = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/table[2]/tbody/tr[3]")).getAttribute("outerHTML");
		return searchData;
		}
	
	public String searchResultsCount() {
		String searchData = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/table[2]/tbody/tr[3]")).getAttribute("outerHTML");
		return searchData;
		}
}     
			            


