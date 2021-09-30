package mainDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonUtility.CommonFunction;

public class TestBase {
	
	
	
	
	
	public static WebDriver driver=null;
	
	
	//multi browser code
	@BeforeMethod
	public void openBrowser()
	{
   
		
		String browserName=CommonFunction.readPropertyFile("browser");//created method which takes parameter as a key from config.properties and returns the corresponding value
		driver=BrowserFactory.initializeDriver(browserName);
		DriverFactory.getInstance().setDriver(driver);
		driver=DriverFactory.getInstance().getDriver();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		CommonFunction.waitforfivesecond();
		//driver.get(url);
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
	
		DriverFactory.getInstance().removeDriver();
		driver.quit();
		
		
	}
	
	

}
