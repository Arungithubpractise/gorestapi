package com.Smyttenapplication.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Smyttenapplication.utility.Webdrivewaitutils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Loginpage {
	
	public AndroidDriver driver;
	Webdrivewaitutils wait;
	
	public Loginpage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id = "com.app.smytten:id/login")
	public WebElement Login;
	
	@AndroidFindBy(id = "com.app.smytten:id/signup_gmail")
	public WebElement sigin;
	
	@AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
	public WebElement gmailselect;
	
	public void clickonLogin()
	{
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(Login, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	
	public void clickonsignin()
	{
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(sigin, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	
	public void clickongmailselect()
	{
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(gmailselect, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);	
	}
}
