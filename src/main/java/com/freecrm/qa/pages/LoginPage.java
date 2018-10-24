package com.freecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	// Page Factory - Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//#loginForm > div > div > input    *[@id="loginForm"]/div/div/input
	//<input type="submit" value="Login" class="btn btn-small">
	//<iframe allowfullscreen="" class="intercom-borderless-frame" name="intercom-borderless-frame" title="Intercom Live Chat" tabindex="-1" style="height: 239px;"></iframe>
	//*[@id="intercom-container"]/div/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div
	//<div class="intercom-blocks"><div class="intercom-block intercom-block-paragraph">Let us know if you have any questions. Please enter your email so we can reply!</div></div>
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")		
	WebElement loginBtn;
	
	@FindBy(css="#navbar-collapse > ul > li:nth-child(2) > a > font")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logoCRM;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		System.out.println("LoginPage Constructor");
	}
	
	public String getLoginPageTitle (){
		return driver.getTitle();
	}
	public boolean validateCRMImage(){
		return logoCRM.isDisplayed();
	}
	
	public HomePage login(String u_name, String pwd)	{
		username.sendKeys(u_name);
		password.sendKeys(pwd);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}

