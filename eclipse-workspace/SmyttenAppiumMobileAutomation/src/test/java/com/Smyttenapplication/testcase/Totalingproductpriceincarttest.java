package com.Smyttenapplication.testcase;

import org.testng.annotations.Test;

import com.Smyttenapplication.pageobject.Loginpage;
import com.Smyttenapplication.pageobject.Totalingproductpriceincart;


public class Totalingproductpriceincarttest extends SmyttenBaseclass {
	
	Loginpage lp;
	 Totalingproductpriceincart tl;
	
	 @Test
	public void validatepropricewithtotalprice (){
		
		 lp = new Loginpage(driver);
		 tl = new Totalingproductpriceincart(driver);
	 
		 lp.clickonLogin();
		 lp.clickonsignin();
		 lp.clickongmailselect();
		 
		 log.info("Totalingproductpriceincarttest case started");
		 
		 tl.clickoncart();
		 log.info("clicked on clickoncart");
		 
		 tl.makingsurecartisempty();
		 log.info("made sure cart is empty");
		 
		 tl.clickonmen();
		 log.info("clicked on clickonmen");
		 
		 tl.selectingpetcare();
		 log.info("clicked on selectingpetcare ");
		 
		 tl.addingelementtocart();
		 log.info("clicked on addingelementtocart");
		 
		 tl.cliconeleentincart();
		 log.info("clicked on  cliconeleentincart");
		 
		 tl.totalingproductsprice();
		 log.info("total price is validated");
		 
		 log.info("Totalingproductpriceincarttest case passed");
	
	}	

}
