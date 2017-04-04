package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author SurajS
 *
 */
public class BrowserFactory {
	 static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("IE"))
		{	
			
			
				System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEpath());			
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				//capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(capabilities);			
				System.out.println(" IE driver set");
			try 
			{
				Runtime.getRuntime().exec("E:\\Suraj\\ss.exe");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error while autoIT"+e.getMessage());
			}			
				
		}
		else if(browserName.equalsIgnoreCase("CM"))
		{
			System.out.print("in CM");
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromepath());
			driver = new ChromeDriver();			
			System.out.print("maximised window in chrome");
			
		}
		else if(browserName.equalsIgnoreCase("FF"))
		{
			System.out.print("in FF");
			driver=new FirefoxDriver();
			System.out.print("maximised window in chrome");
			
		}
		System.out.print("after IE set");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	public static void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
