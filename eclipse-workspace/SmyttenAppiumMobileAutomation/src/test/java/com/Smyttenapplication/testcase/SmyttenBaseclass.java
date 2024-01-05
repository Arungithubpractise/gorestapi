package com.Smyttenapplication.testcase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Smyttenapplication.utility.Readconfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SmyttenBaseclass {
	
	  
	public  Logger log;
	public AppiumDriverLocalService service;
	public Readconfig read;
	public static AndroidDriver driver;

	@BeforeMethod
	public void setup() throws IOException
	{
		
		 read = new Readconfig();
		
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\arunn\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
		        withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(2000)).build();
			  
		service.start();
				    
		UiAutomator2Options  options = new UiAutomator2Options();
		
		options.setDeviceName(read.getDeviceName());
		options.setPlatformName(read.getPlatformName());
		options.setAutomationName(read.getAutomationName());
		options.setApp(read.getApppath());
		//options.setAppPackage("com.app.smytten");
		//options.setAppActivity("com.app.smytten.ui.home.HomeActivity");
		///options.setAppWaitForLaunch(true);
		//options.setNoReset(true);
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		  log = Logger.getLogger(SmyttenBaseclass.class);
		  
			 PropertyConfigurator.configure("Log4j.properties");
			 
			 Layout layout = new PatternLayout("%d  %c %m  %n");
			Appender appender = new FileAppender(layout, ".//log//Logging.log");
			BasicConfigurator.configure(appender);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	public  String randomString() {
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);

	}
		
@AfterMethod
	public void teardown() 
	{
	service.stop();
	driver.quit();
	}


public static String takeScreenshot(String testName,AndroidDriver driver) 
{
    TakesScreenshot ts = (TakesScreenshot) driver;                                                     
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+Timestamp()+".png"); 
	try {
		FileUtils.copyFile(source, target);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return target.getAbsolutePath();

}

public static String Timestamp()
{
	Date date = new Date();
	return date.toString().replace(" ","_" ).replace(":", "_");
	
}

	
}

