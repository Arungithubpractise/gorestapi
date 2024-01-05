package com.Smyttenapplication.testcase;

import org.testng.annotations.Test;

import com.Smyttenapplication.pageobject.Loginpage;
import com.Smyttenapplication.pageobject.gesturespage;

public class gesturestest extends SmyttenBaseclass {
		

	Loginpage lp;
	gesturespage rest;
	
	@Test
	public void swipe_scroll()  {
		
		 lp = new Loginpage(driver);
		 rest = new gesturespage(driver);
		 
		 lp.clickonLogin();
		 lp.clickonsignin();
		 lp.clickongmailselect();
		 
		log.info("gesturestest case started");
		
		rest.scroll_swipe_taponelement();
		log.info("scroll_swipe gesture is success");
		
		rest.doubletap();
		log.info("doubletap gesture is success");
		
		rest.clipboardtext();
		log.info("clipboardtext gesture is success");
		
		rest.longpress();
		log.info("longpress is success ");
		
		log.info("gesturestest test case passed ");
		
	}

}
