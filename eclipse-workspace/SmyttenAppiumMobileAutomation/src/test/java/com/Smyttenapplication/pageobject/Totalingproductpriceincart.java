package com.Smyttenapplication.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Smyttenapplication.utility.Reusemethods;
import com.Smyttenapplication.utility.Webdrivewaitutils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Totalingproductpriceincart {
	
	public AndroidDriver driver;
	Reusemethods reuse;
	Webdrivewaitutils wait;
	
	public Totalingproductpriceincart(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Cart\"]/android.widget.FrameLayout/android.widget.ImageView")
	public WebElement cart;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"SHOP\"]")
	public WebElement shop;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")
	public WebElement men;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'PET CARE']")
	public WebElement petcare;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ALL PET CARE']")
	public WebElement allpetcare;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Barkstix Dog Treats for Training Adult Puppies')]")
	public WebElement Barkstixtext;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADD TO CART']")
	public WebElement addtocart;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Paw Cream For Dogs And Cats')]")
	public WebElement pawcreamtext;
	
	@AndroidFindBy(id = "com.app.smytten:id/iv_cart")
	public WebElement eleentincart;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")
	public List<WebElement> productsincart;
	
	@AndroidFindBy(xpath = "//*[@resource-id = 'com.app.smytten:id/price']")
	public List<WebElement> productsprice;
	
	@AndroidFindBy(id = "com.app.smytten:id/tv_total_payable_rs")
	public WebElement totalpayRs;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	public  WebElement deleatebutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='Remove']")
	public WebElement Remove;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Your Cart is Currently Empty']")
	public WebElement cartemptytext;
	
	@AndroidFindBy(id = "com.app.smytten:id/iv_close")
	public WebElement cartback;
	
	

	
	
	public void clickoncart()
	{
		 reuse = new Reusemethods();
		 reuse.taponelement(cart);
	}
	
	public void makingsurecartisempty()
	{
	 wait = new Webdrivewaitutils(driver);
		int size = productsincart.size();
		 reuse = new Reusemethods();
		 	 
		for(int i=0; i<size; i++) 
		{
			if(size!=0)
			{
				deleatebutton.click();
				reuse.taponelement(Remove);
				
				
			}
			else if(size==0)
			{
				break;
			}
			
			
		}
		cartback.click();;
		wait.clickOnElement(shop, 2000);
		
	}
	
	
	public void clickonmen()
	{
		men.click();
	}
	
	public void selectingpetcare()
	{
		driver.findElement(AppiumBy.androidUIAutomator(
		"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"SKINCARE\").instance(0))"));

		reuse.taponelement(petcare);
		reuse.taponelement(allpetcare);
	
	}
	
	
	public void addingelementtocart()
	{
		wait = new Webdrivewaitutils(driver);
		
		wait.clickOnElement(Barkstixtext, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		
		wait.clickOnElement(addtocart, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		wait.clickOnElement(pawcreamtext, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
			
		wait.clickOnElement(addtocart, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
				
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void cliconeleentincart()
	{
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(eleentincart, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void totalingproductsprice()
	{
		int size = productsincart.size();
		int sumprice = 0 ;
		
		for(int i=0; i<size; i++) 
		{	
				String price = productsprice.get(i).getText();
				int sum = Integer.parseInt(price.substring(1));
				sumprice = sumprice+sum;
		
			}
			
		String totalprice = totalpayRs.getText();
		int totpri = Integer.parseInt(totalprice.substring(1));
		Assert.assertEquals(sumprice, totpri);
		
	}
		
	}


