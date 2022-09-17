package com.webappsecurity.zero.TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {
	
	protected WebDriver  driver;
	@BeforeClass
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

		driver = new ChromeDriver(capability);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");
		
		
	}
		
	
	@AfterClass
	public void closeApplication() {
		driver.quit();
	}

}
