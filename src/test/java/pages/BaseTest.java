package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import dataProvider.ConfigDataProvider;


import factory.BrowserFactory;


public  class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	
		@BeforeClass
		public void setup(){	
			report = new ExtentReports(".\\Reports\\LoginPageReport.html", true);
			logger=report.startTest("Verify login page");
			driver=BrowserFactory.getBrowser("IE");
			logger.log(LogStatus.INFO, "Application is up IE and Running");
			driver.get(ConfigDataProvider.getprop("Testurl"));
			logger.log(LogStatus.INFO, "URL passed to browser");
		}	
		@AfterClass
		void teardown()
		{		
			BrowserFactory.quitBrowser(driver);			
		}
		
}
