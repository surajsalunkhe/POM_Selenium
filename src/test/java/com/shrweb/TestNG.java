package com.shrweb;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG {
	InternetExplorerDriver driver;
	Logger logger=Logger.getLogger("TestNG");

	@BeforeTest
	public void setup()
	{
		PropertyConfigurator.configure("Log4j.properties");
		String iEserver="E:\\Suraj\\IEDriverServer.exe";	
		System.setProperty("webdriver.ie.driver", iEserver);
		logger.info("===Test Started====");
		driver = new InternetExplorerDriver();
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}
	@Test(testName="log",description = "This is really a simple crazy test")
	public void teststart()
	{
		driver.manage().window().maximize();
		logger.info("--Browser started--");
		String url="http://google.com";
		driver.get(url);
		Reporter.log("=====Application Started=====", true);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
	}

  
}
