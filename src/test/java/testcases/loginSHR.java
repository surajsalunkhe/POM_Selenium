/**
 * 
 */
package testcases;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.FunctionFactory;
import pages.BaseTest;
import pages.loginPage;

/**
 * @author surajs
 *
 */
public class loginSHR extends BaseTest {		

	@Test
	public void loginshr()
	{		
		System.out.println("\n In test");				
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.loginMethod();
		logger.log(LogStatus.INFO, "Login succesful");
		String title=FunctionFactory.getTitle();	
		System.out.println("Page title="+title);		
		Assert.assertEquals(title, "Login - DPM-SHR");
		logger.log(LogStatus.PASS, "Login Verified");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		// Thread.sleep(10000);

		if (result.getStatus() == ITestResult.FAILURE) {
			//String path = Utility.capscreen(driver, result.getName());			
		}
		BrowserFactory.quitBrowser(driver);
		report.endTest(logger);
		report.flush();
		
	}
		
}
