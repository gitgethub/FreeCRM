package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest(){
		super();
		System.out.println("LoginPageTest Constructor");
	}
	
@BeforeMethod
public void setup() {
	initialization();
	lp = new LoginPage();
}

@Test(priority=1)
public void verifyTitle() {
	String loginTitle = lp.getLoginPageTitle();
	Assert.assertEquals(loginTitle, "#1 Free CRM software in the cloud for sales and service");
}

@Test(priority=2)
public void verifyImage() {
	boolean imgExists = lp.validateCRMImage();
	Assert.assertEquals(imgExists, true);
}

@Test(priority=3)
public void loginStdUser() {
	String un = prop.getProperty("username");
	String pd = prop.getProperty("password");
	hp = lp.login(un, pd);
}

@AfterMethod
public void tearDown() {
	driver.quit();
}


}

