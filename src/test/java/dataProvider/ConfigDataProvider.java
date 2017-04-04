package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * @author SurajS
 *
 */
public class ConfigDataProvider {
	static Properties pro;
	private static  Logger log=Logger.getLogger(ConfigDataProvider.class);
	
	//constructor and load properties file
	public ConfigDataProvider(){
		
		File src=new File("./config/path.properties");		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			log.info("Properties file loaded");
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			log.info("Properties file exception:"+e.getMessage());
		}
	}
	
	public  String getIEpath()
	{
		String dpath=pro.getProperty("IEpath");	
		log.info("Internet explorer path found");
		return dpath;
	}
	public  String getChromepath()
	{
		String dpath=pro.getProperty("Chromepath");
		log.info("Chrome path found");
		return dpath;
	}
	public  String getURL()
	{		
		String url=pro.getProperty("Testurl");
		log.info("Test URL found");
		return url;
	}
	
	
	public static By getByObject(String locatorkey)
	{
		By by=null;
		String value=(String)pro.getProperty(locatorkey);
		if(locatorkey.startsWith("id")){
			by=By.id(value);
		}else if(locatorkey.startsWith("name")){
			by=By.name(value);
		}else if(locatorkey.startsWith("class")){
			by=By.className(value);
		}else if(locatorkey.startsWith("css")){
			by=By.cssSelector(value);
		}else if(locatorkey.startsWith("link")){
			by=By.linkText(value);
		}else if(locatorkey.startsWith("plink")){
			by=By.partialLinkText(value);
		}else if(locatorkey.startsWith("tag")){
			by=By.tagName(value);
		}else if(locatorkey.startsWith("xpath")){
			by=By.xpath(value);
		}else
			by = By.cssSelector(value);
			return by;
			
	}
	public static String getprop(String locatorkey)
	{
		String pdata=pro.getProperty(locatorkey);
		return pdata;
	}
	

}
