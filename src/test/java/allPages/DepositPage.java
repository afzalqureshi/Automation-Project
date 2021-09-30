package allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.CommonFunction;
import mainDriver.TestBase;

public class DepositPage extends TestBase{
	
	CommonFunction commonfunction = new CommonFunction();
	
	@FindBy(xpath="//button[@ng-class='btnClass2']")
	public WebElement DepositButton;
	
	@FindBy (xpath="//input[@type='number']")
	public WebElement DepositAmountTextBox;
	
	@FindBy (xpath ="//button[@type='submit']")
	public WebElement DepositButton2;
	
	@FindBy (xpath="//span[@class='error ng-binding']")
	public WebElement DepositSuccessfulMessage;
	
	public DepositPage() {
		PageFactory.initElements(driver, this);
		
	
	}
	
	public void enterAmountToBeDeposited() {
		commonfunction.enterData(DepositAmountTextBox, "100", "Amount entered successfully");
		
	}
	
	public void clickOnDepositButton() {
		commonfunction.clickElement(DepositButton, "Clicked on Deposit button");
	}
	
	public void validateMessage() {
		commonfunction.isElementPresent(DepositSuccessfulMessage, "Desposit Successful Message Displayed");
	}
}
