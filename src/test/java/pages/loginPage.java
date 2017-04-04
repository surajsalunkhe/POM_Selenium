package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import factory.Constants;


public class loginPage{
	 WebDriver driver;
	public static Logger log=Logger.getLogger(loginPage.class);	 
 
	 
	 @FindBy(xpath="//input[@id='userID']") private WebElement username;
	 @FindBy(xpath="//input[@id='pwd']") private WebElement password;
	 @FindBy(xpath="//input[@id='bpID']") private WebElement bpID;
	 @FindBy(xpath="//input[@id='loginButton']/preceding::input[1]") private WebElement pwd_check;
	 @FindBy(xpath="//input[@id='loginButton']") private WebElement login_button;
	 
	public  loginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		System.out.print("In constructor");		
	}	
	public  void loginMethod()
	{
			
		username.sendKeys(Constants.maker_id);
		log.info("User ID entered");
		password.sendKeys(Constants.maker_pwd);
		log.info("Password entered");
		bpID.sendKeys(Constants.rta_id);
		log.info("RTA ID entered");
		pwd_check.click();
		log.info("Password checkbox clicked");
		login_button.submit();							
	}
	
	

}
