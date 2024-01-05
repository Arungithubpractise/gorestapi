package com.Smyttenapplication.testcase;

import org.testng.annotations.Test;

import com.Smyttenapplication.pageobject.Loginpage;

public class Logintest extends SmyttenBaseclass {
	
	Loginpage lp;
	
	@Test
	public void logintest() throws InterruptedException {
		
		 lp = new Loginpage(driver);
		 
		 log.info("logintest case started");
		 
		 lp.clickonLogin();
		 log.info("clicked on login button");
		 
		 lp.clickonsignin();
		 log.info("clicked on clickonsignin button");
		 
		 lp.clickongmailselect();
		 log.info("clicked on clickongmailselect button");
		 
		 log.info("logintest test case passed ");
 
	}
	


}