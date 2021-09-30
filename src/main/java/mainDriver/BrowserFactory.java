package mainDriver;//multibrowser opening code based on browser parameter from property file.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {





	public static WebDriver initializeDriver(String browser)
	//method is called in TestBase class
	{
		WebDriver driver=null;

		try {

			if(browser.toLowerCase().equals("chrome"))
			{
				ChromeBrowserProfile profile=new ChromeBrowserProfile();//here is the data hiding.. 
				//i have called all methods in my constructor(in ChromeBrowserProfile, setdriver) 
				//and just i have created an object of the class and all the methods are pointing 
				//to my abstract class
				driver=new ChromeDriver();

			}
			else if(browser.toLowerCase().equals("firefox"))//this browser parameter(firefox) i am using from properties file.
			{

				FirefoxBrowserProfile profile=new FirefoxBrowserProfile();

				driver=new FirefoxDriver();


			}
            driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

}
