package mainDriver;//assign unique thread ID to each browser. for || testing

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	
	public static DriverFactory instance=new DriverFactory();//instance is a variable 
	//i have created static object of the class so i can access all non static items of the class.
	
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();//made webdriver object using thread local


	private DriverFactory()//if private constructor, you can't call its methods. Encapsulation is combining data and code into single unit
	{
		
		
	}
	
	
	public static DriverFactory getInstance()//i have created this method so i can directly 
	//access any method of the class with the help of this method.  reason behind that it returns 
	//type as a class.  DriverFactory class is used as a return type.
	{
		
		
		return instance;
	}
			
	
	
	
	public WebDriver getDriver()//means i get driver with unique id
	{
		
		
		
		return driver.get();
		
	}
	
	
	
	public void setDriver(WebDriver driverParam)//means i set driver with unique ID(so no collision)
	{
		
		
		driver.set(driverParam);
		
		
		
	}
	
	
	public void removeDriver()
	{
		
		driver.get().quit();
		driver.remove();
		
		
		
	}
	
	
	
	
	

}
