package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class NewDealsPage extends TestBase {
	
	public NewDealsPage()	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//legend[@class='fieldset' and contains(text(),'Deal')]")
	@CacheLookup
	WebElement pageHeaderLabel;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[1]/strong")
	@CacheLookup
	WebElement labelDealNo;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[1]/strong")
	@CacheLookup
	WebElement labelTitle;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[1]/strong")
	@CacheLookup
	WebElement labelCompany;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td[1]/strong")
	@CacheLookup
	WebElement labelPrimaryContact;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[5]/td[1]/strong")
	@CacheLookup
	WebElement labelAmount;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	@CacheLookup
	WebElement textCompany;
	
	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/input[4]")
	@CacheLookup
	WebElement companyLookupLink;

	@FindBy(xpath="//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td[2]/input[4]")
	@CacheLookup
	WebElement contactLookupLink;
	
	@FindBy(xpath="//input[@type='submit' and @value='Search']")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath="//input[@name='search']")
	@CacheLookup
	WebElement searchTextbox;
	
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/a")
	@CacheLookup
	WebElement searchResultLink;
	
	@FindBy(xpath="//input[@name='search' and @id='search']")
	@CacheLookup
	WebElement searchContactTextbox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Search']")
	@CacheLookup
	WebElement btnContactSearch;
	
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td/table/tbody/tr[7]/td/a")
	@CacheLookup
	WebElement searchContactResultLink;
	
	@FindBy(xpath="//input[@name='title']")
	@CacheLookup
	WebElement textTitle;
	
	@FindBy(xpath="//input[@name='amount']")
	@CacheLookup
	WebElement textAmount;
	
	@FindBy(xpath="//select[@name='product_id']")
	@CacheLookup 
	WebElement selectProduct;
	
	@FindBy(xpath="//input[@name='probability']")
	@CacheLookup
	WebElement percentageProbability;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='exclude_reports']")
	@CacheLookup
	WebElement checkExcludeFromReports;
	
	@FindBy(xpath="//select[@name='source']")
	@CacheLookup
	WebElement selectSource;
	
	@FindBy(xpath="//input[@type='radio' and  @name='closed' and @value='Y']")
	@CacheLookup
	WebElement radioClosed;
	
	@FindBy(xpath="//input[@type='submit' and @name='addmore']")
	@CacheLookup
	WebElement buttonSaveandCreateAnother;
	
	@FindBy(xpath="//input[@type='text' and @name='sequence']")
	WebElement labelDealNoSequence;
	
	@FindBy(xpath="//input[@name='commission']")
	@CacheLookup
	WebElement commissionPercentage;
	
	public void enterCommissionPercentage(int percentage)	{
		commissionPercentage.sendKeys(String.format("%s", percentage));
	}
	
	public int getDealNoSequence()	{
		int value;
		value = Integer.parseInt(labelDealNoSequence.getAttribute("value"));
		return value;
	}
	
	public void clickSaveandCreateAnother()	{
		buttonSaveandCreateAnother.click();
	}
	
	public void enableStatusClosed()	{
		radioClosed.click();
	}
	
	public void selectSource(String text) {
		Select select = new Select(selectSource);
		select.selectByVisibleText(text);
	}
	
	public void enableExcludeFromReports()	{
		checkExcludeFromReports.click();
	}
	
	public void enterProbabilityPercentage(int percentage)	{
		percentageProbability.sendKeys(String.format("%s", percentage));
	}
	
	public void selectProduct(String text) {
		Select select = new Select(selectProduct);
		select.selectByVisibleText(text);
	}
	
	public boolean pageHeaderLabelDisplayed() {
		return pageHeaderLabel.isDisplayed();
	}
	
	public boolean labelDealNoDisplayed() {
		return labelDealNo.isDisplayed();
	}
	
	public boolean labelTitleDisplayed() {
		return labelTitle.isDisplayed();
	}
	
	public boolean labelPrimaryContactDisplayed() {
		return labelPrimaryContact.isDisplayed();
	}
	
	public boolean labelAmountDisplayed() {
		return labelAmount.isDisplayed();
	}
	
	public boolean labelCompanyDisplayed() {
		return labelCompany.isDisplayed();
	}
	
	public void enterCompanyName(String value)	{
		textCompany.sendKeys(value);
	}
	
	public void clickCompanyLookupLink()	{
		companyLookupLink.click();
	}
	
	public void clickContactLookupLink()	{
		contactLookupLink.click();
	}
	
	public String getCompanyLookupTitle()	{
		return driver.getTitle();
	}
	
	public String getContactLookupTitle()	{
		return driver.getTitle();
	}
	
	public void enterSearchText(String text) {
		searchTextbox.sendKeys(text);
	}
	
	public void clickSearchButton() {
		btnSearch.click();
	}
	
	public void clickOnSearchResultLink()	{
		searchResultLink.click();
	}
	
	public void clickContactSearchButton()	{
		btnContactSearch.click();
	}
	
	public void enterContactSearchText(String text) {
		searchContactTextbox.sendKeys(text);
	}
	
	public void clickOnContactSearchResultLink()	{
		searchResultLink.click();
	}
	
	public void enterTitleText(String text)		{
		textTitle.sendKeys(text);
	}
	
	public void enterAmountValue(int amount)		{
		textAmount.sendKeys(String.format("%s", amount));
	}
}
