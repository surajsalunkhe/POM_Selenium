package pages;



import org.openqa.selenium.WebDriver;


public  class BaseClass {
	protected static WebDriver driver;

	public BaseClass(WebDriver driver)
	{
		BaseClass.driver=driver;
		System.out.println("In base class");
	}
	
	
}
