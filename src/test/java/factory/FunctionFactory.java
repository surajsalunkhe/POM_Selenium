package factory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dataProvider.ConfigDataProvider;

public class FunctionFactory extends BrowserFactory{	

	private static  Logger log=Logger.getLogger(FunctionFactory.class);
	
	
	public static String getTitle(){		
		String title=driver.getTitle();
		System.out.println("In function factory constructor"+title);
		return title;
		
	}
	public static String navigateURL(String url)
	{
		try {			
			driver.get(url);
			log.info("URL added");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Fail - Invalid URL: " + url;
		}
		return "pass";
	}
	
	public static String getWindowHwndID() {
		Set<String> windows = driver.getWindowHandles();		
		Iterator<String> itr = windows.iterator();
		String windowID = null;
		log.info("Getting winodw handles");
		while(itr.hasNext())
			windowID = itr.next();		
		
		return windowID;
	}
	
	public static boolean isElementPresent(String PathExpr ) {
		try {
			driver.findElement(ConfigDataProvider.getByObject(PathExpr));
			log.info("Element found"+PathExpr);
		}catch(Exception e) {			
			log.info("Element Not found"+PathExpr);
			return false;
		}		
		return true;
	}
	
	public static boolean dragDrop(String PathExpr, String PathExpr1 ) {
		try {
			WebElement From=driver.findElement(ConfigDataProvider.getByObject(PathExpr));
			WebElement To=driver.findElement(ConfigDataProvider.getByObject(PathExpr1));
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
			dragAndDrop.perform();
			log.info("Drag and drop action performed");
		
		}catch(Exception e) {
			System.out.println("Element does not Exist: " + PathExpr);
			log.info("Unable to perform Drag and drop action");
			return false;
		}		
		return true;
	}
	public static boolean hoverclick(String PathExpr, String PathExpr1 ) {
		try {			
			WebElement ele1=driver.findElement(ConfigDataProvider.getByObject(PathExpr));			
			if(ele1.isDisplayed())
			{
				WebElement ele2=driver.findElement(ConfigDataProvider.getByObject(PathExpr1));
				if(ele2.isEnabled())
				{
					Actions act = new Actions(driver);
					act.moveToElement(ele1).build().perform();
					act.click(ele2);
					log.info("sucesfully clicked");
				}else{
					ele1.click();
					log.info("No element is enabled found for click");
				}
				
			}else{
				log.info("clickable element is not exist");
			}
											
		}catch(Exception e) {
			log.info("exception occured while hover click"+e.getMessage());
			return false;
		}		
		return true;
	}
	
	
	public static WebElement ExpWait(String PathExpr)
	{		
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement element=(WebElement) ConfigDataProvider.getByObject(PathExpr);
			wait.until(ExpectedConditions.elementToBeClickable(element));			
			return element;
	}
	
	public static String simpleAlert()
	{
		Alert alt=driver.switchTo().alert();
		String alt_text=alt.getText();
		alt.accept();
		return alt_text;		
	}
	public static String confirmAlert(String stat)
	{
		Alert alt=driver.switchTo().alert();
		String alt_text=alt.getText();
		if(stat.equalsIgnoreCase("Accept")){
			alt.accept();
		}else{
			alt.dismiss();
		}
		return alt_text;		
	}
	public static String promptAlert(String stat,String data)
	{
		Alert alt=driver.switchTo().alert();
		String alt_text=alt.getText();
		alt.sendKeys(data);
		alt.accept();		
		return alt_text;		
	}
	public static void scriptTimeout()
	{
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
	}
	public static void pageLoadTimeout()
	{
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}
	
	public static String type(String object,String data)
	{
		try {
		driver.findElement(ConfigDataProvider.getByObject(object)).sendKeys(data);
		}
		catch(Exception e){
			return "Fail - Invalid type Action on element: " + object + "  --  " + data;
		}
		return "Pass";
	}
	
	
}//end of factory

