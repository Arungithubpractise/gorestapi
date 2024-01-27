package com.Smyttenapplication.pageobject;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.Smyttenapplication.utility.Reusemethods;
import com.Smyttenapplication.utility.Webdrivewaitutils;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class gesturespage {
	
	public AndroidDriver driver;
	Reusemethods reuse;
	Webdrivewaitutils wait;
	
	public gesturespage(AndroidDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath  = "//android.widget.TextView[@text = 'Shop']")
	public WebElement Shop;
	
	//@AndroidFindBy(xpath  = "//android.widget.TextView[@text = '𝐒𝐇𝐎𝐏 𝐍𝐎𝐖']")
	//public WebElement shopnow;
	
	@AndroidFindBy(xpath = "//*[@resource-id = 'com.app.smytten:id/ll_root_row_trial_featured']")
	public WebElement exploreswipeelement;
	
	@AndroidFindBy(xpath = "(//*[@resource-id = 'com.app.smytten:id/ll_root_row_trial_featured'])[2]")
	public WebElement exploreclickelement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wood Cold Pressed Sunflower Cooking Oil']")
	public WebElement oil;
	
	@AndroidFindBy(id = "com.app.smytten:id/image")
	public WebElement image;
	
	@AndroidFindBy(id = "com.app.smytten:id/image")
	public WebElement image1;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")
	public WebElement search;
	

	@AndroidFindBy(id = "com.app.smytten:id/et_search")
	public WebElement searchbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Men Deserve']")
	public WebElement MenDeserve;
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text = 'Menu']")
	public WebElement menu;
	
	@AndroidFindBy(accessibility  = "Messages")
	public WebElement Messages;
	
	public void scroll_swipe_taponelement() throws InterruptedException
	{
		reuse = new Reusemethods();
		reuse.taponelement(Shop);
		
		//scroll
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"𝐓𝐎𝐏 𝐏𝐈𝐂𝐊𝐒\").instance(0))"));
		
		//swipe
		
		
		((JavascriptExecutor) driver). executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) exploreswipeelement). getId(),
		                         "direction", "left",
		                         "percent", 0.75));
		
		///////////////////////////////////////////////////////////////////////////////////
		                         
		//swipe 
		                         
		/*Point location = upto58.getLocation();
		Dimension size = upto58.getSize();
		
		Point xy = driver.manage().window().getPosition();
		
		System.out.println(xy);
	
		
		Point centerofele = getcenterofelement(location,size);	
			
						
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

				Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(209)))
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xy))
				.addAction(finger1.createPointerUp(PointerInput .MouseButton.LEFT.asArg()));

				driver .perform(Collections.singletonList (sequence) );*/
	
		
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(exploreclickelement, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);	
		

	}
	
	public void doubletap()
	{
		reuse = new Reusemethods();
		
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(oil, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(image, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		
	
		reuse.Doubletaponelement(image1);
		
		
	}
	
	public void clipboardtext()
	{
		for(int i=0; i<=3; i++)
		{
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(search, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(searchbox, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	
		
		driver.setClipboardText("Men d");
		searchbox.sendKeys(driver.getClipboardText());
		
		wait.clickOnElement(MenDeserve, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void longpress()
	{
		reuse = new Reusemethods();
		
		for(int i=0; i<=2; i++)
		{
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		
		reuse.Longpress(menu);                        //we can see Tool tip after long press
	}
	

	public void screenrotate()
	{
		for(int i=0; i<=3; i++)
		{
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(Messages, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
		
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);

	}
	
	

	public Point getcenterofelement(Point location, Dimension size )
	{
		return new Point(location.getX()+ size.getWidth()/2, location.getY()+size.getHeight()/2);
		
	}	
	
}
