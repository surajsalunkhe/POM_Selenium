package factory;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jmx.snmp.Timestamp;

public class Utility {
	public static String capscreen(WebDriver driver)
	{
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			Date d=new Date();
			Timestamp t = new Timestamp(d.getTime());
			String timeStamp = t.toString();
			timeStamp = timeStamp.replace(' ', '_');
			timeStamp = timeStamp.replace(':', '_');
			String dest="E:\\Suraj\\Selenium\\SHR\\screens"+timeStamp+".jpg";
			File destination=new File(dest);
			FileUtils.copyDirectory(src, destination);
			System.out.println("Screenshot captured");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
			return e.getMessage();
		} 
				
	}//end of capscreen
	public static String capscreen(WebDriver driver,String screenshotname)
	{
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			Date d=new Date();
			Timestamp t = new Timestamp(d.getTime());
			String timeStamp = t.toString();
			timeStamp = timeStamp.replace(' ', '_');
			timeStamp = timeStamp.replace(':', '_');
			String dest="E:\\Suraj\\Selenium\\SHR\\screens"+screenshotname+timeStamp+".jpg";
			File destination=new File(dest);
			FileUtils.copyDirectory(src, destination);
			System.out.println("Screenshot captured");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
			return e.getMessage();
		} 
				
	}//end of capscreen with screenshot name
}
