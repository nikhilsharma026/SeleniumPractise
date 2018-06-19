package com.js;


import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSErrorsDemo {
	WebDriver driver;
	Logger logs;
	
	@BeforeMethod
	public void init() {
	DesiredCapabilities cap = DesiredCapabilities.firefox();
	LoggingPreferences logging = new LoggingPreferences();
	logging.enable(LogType.BROWSER, Level.ALL);
	cap.setCapability(CapabilityType.LOGGING_PREFS, logging);
	driver = new FirefoxDriver(cap);
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void yifySite() {
		driver.get("https://yts.am/browse-movies");
		getJSErrorLogs();
		
	}
	
	public void getJSErrorLogs() {
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		
		
		for(LogEntry entry : entries) {
			
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
				
				}
			
			
			
		}
	
	
	
}
