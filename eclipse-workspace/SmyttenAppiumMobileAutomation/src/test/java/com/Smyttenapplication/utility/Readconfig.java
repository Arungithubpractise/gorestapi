package com.Smyttenapplication.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	 Properties pro ;
	
	 public Readconfig() 
	{
		File fil =new File("C:\\Users\\arunn\\eclipse-workspace\\SmyttenAppiumMobileAutomation\\configuration\\configuration.properties");
		
		try 
		{
			FileInputStream file = new FileInputStream(fil);
			 pro =new Properties();
			 pro.load(file);
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
}


public  String getDeviceName()
{
	String devname = pro.getProperty("DeviceName");
	return devname;
}
public  String getPlatformName()
{
	String plname = pro.getProperty("PlatformName");
	return plname;
}

public  String getAutomationName()
{
	String Autname = pro.getProperty("AutomationName");
	return Autname;
}
public  String getApppath()
{
	String Apppath = pro.getProperty("Apppath");
	return Apppath;
}



}






