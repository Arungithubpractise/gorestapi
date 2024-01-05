package com.Smyttenapplication.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {
	
	 ExtentReports extentReport;
	
	 public ExtentReports generateExtentReport() {
		
		extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		//File extentReportFile = new File(".//test-output//ExtentReports//extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("smytten application execcution report");
		sparkReporter.config().setDocumentTitle("smytten Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);	
		
		Readconfig read = new Readconfig();
		
		extentReport.setSystemInfo("DeviceName",read.getDeviceName());
		extentReport.setSystemInfo("AutomationName",read.getAutomationName());
		extentReport.setSystemInfo("PlatformName",read.getPlatformName());
		extentReport.setSystemInfo("Apppath",read.getApppath());
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
	}
	
}