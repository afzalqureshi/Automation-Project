package commonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import mainDriver.TestBase;

public class CommonFunction extends TestBase

{


	/**
	 * @author Afzal
	 * Description: This method is used to click on any Element
	 * @param element
	 * @param data
	 */


	public void clickElement(WebElement element,String message)
	{

		try {

			element.click();

		} catch (Exception e) {
			e.printStackTrace();
		}




	}


	/**
	 * @author MYSHA
	 * Summary: This method i is used for clicking on any element by using javascriptexecuter.
	 * @param element
	 * @param data
	 */
	public void clickUsingJavascriptExecuter(WebElement element,String data)
	{

		try {

			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);	
		} catch (Exception e) {
			e.printStackTrace();

		}

	}	



	/**
	 * @author MYSHA
	 * Summary: This method is used to enter data
	 * @param element
	 * @param data
	 * @param message
	 */


	public void enterData(WebElement element,String data,String message)
	{

		try {

			element.sendKeys(data);


		} catch (Exception e) {
			e.printStackTrace();
		}


	}





	/**
	 * @author MYSHA
	 * Summary: This method is used to enter data using Actions Class	
	 * @param element
	 * @param data
	 * @param message
	 */
	public void enterDataUsingAction(WebElement element,String data,String message)
	{


		try {

			Actions action=new Actions(driver);
			action.moveToElement(element).sendKeys(data).build().perform();


		} catch (Exception e) {
			e.printStackTrace();
		}




	}


	/**
	 * @author MYSHA
	 * Summary: This method is used to click on any element using Actions class
	 * @param element
	 * @param data
	 */
	public void clickUsingAction(WebElement element,String data)
	{


		try {

			Actions action=new Actions(driver);
			action.click(element).build().perform();///action.moveToElement(element).click().build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}





	}

	/**
	 * Summary:This Method is used to select the value from dropdown by index
	 * @param element
	 * @param index
	 * @param message
	 */

	public void selectDropdownByIndex(WebElement element,int index,String message)
	{

		try {

			Select select=new Select(element);
			select.selectByIndex(index);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}


	/**
	 * Summary: This Method is used to select value from drop down
	 * @param element
	 * @param value
	 * @param message
	 */
	public void selectdropdownByValue(WebElement element,String value,String message)
	{

		try {

			Select select=new Select(element);
			select.selectByValue(value);


		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	/**
	 * Summary: This method is used to select drop down value by visible text.
	 * @param element
	 * @param text
	 * @param message
	 */

	public void selectDropdownByVisibleText(WebElement element,String text,String message)
	{

		try {

			Select select=new Select(element);
			select.selectByVisibleText(text);

		} catch (Exception e) {

			e.printStackTrace();
		}



	}


	/**
	 * Summary: This method is used to move in frame by using xpath
	 * @param element
	 */


	public void moveToFrameByXpath(WebElement element)
	{


		try {

			driver.switchTo().frame(element);

		} catch (Exception e) {
			e.printStackTrace();
		}




	}



	/**
	 * Summary: This method is used to move in frame by using Index
	 * @param element
	 */


	public void moveToFrameByIndex(int index)
	{


		try {

			driver.switchTo().frame(index);

		} catch (Exception e) {
			e.printStackTrace();
		}




	}

	/**
	 * Summary: This method is used to outSide from a frame
	 */
	public void moveOutSideFrame()
	{


		try {

			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
	/**
	 * Summary: This method is used to handle Nested Frame
	 * @param firstframe
	 * @param secondFrame
	 */
	public void frameWithinFrame(WebElement firstframe,WebElement secondFrame)
	{


		try {

			driver.switchTo().frame(firstframe).switchTo().frame(secondFrame);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 * 
	 * Summary: This method is used to move in new window
	 */
	public void moveToNewWindow()
	{


		try {


			Set<String> set=driver.getWindowHandles();
			//get window handle and store it in set

			Iterator<String> itr=set.iterator();//pass string as a parameter


			while(itr.hasNext())
			{



				String newwindow=itr.next();

				driver.switchTo().window(newwindow);//pasing new window parameter

			}



		} catch (Exception e) {
			e.printStackTrace();
		}



	}


	/**
	 * Summary: This method is used to getting old window handle.
	 * @return
	 */

	public String oldWindowHandle()
	{

		String handle="";
		try {

			handle=driver.getWindowHandle();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return handle;

	}



	/**
	 * Summary: This method is used to move old window
	 * @param oldwindow
	 */

	public void moveTooldWindow(String oldwindow)
	{

		try {


			driver.switchTo().window(oldwindow);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	/**
	 * 
	 * @param element
	 * @param data
	 */

	public void isElementPresent(WebElement element,String data)
	{

		boolean flag=false;//
		try {

			flag=element.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
		}





	}


	public static String readPropertyFile(String key)

	{
		String value="";
		try {
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\enviornmentProperties\\config.properties";
			FileInputStream file=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(file);

			value=prop.getProperty(key);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;




	}


	public String captureScreenshot()
	{
		String path=""; 
		try {

			String expectedpath=System.getProperty("user.dir")+"\\screenshots\\";

			//This is interface and we are binding with driver.
			TakesScreenshot screen=((TakesScreenshot)driver);

			//Here by getscreenshotAs method is used to capturing screenshot with output type file
			//because it returns file so i have stored in file type
			File actual=screen.getScreenshotAs(OutputType.FILE);

			//getting current time in milisecond
			long time=System.currentTimeMillis();
			path=expectedpath+"screenshot"+time+".png";

			//So here i am reading expected folder path with file
			File expected=new File(path);

			//This class have method copyfile which is used to copy file from one location to another.
			FileUtils.copyFile(actual, expected);









		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;





	}

	public static void waitforfivesecond()
	{
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}	


	}

}
