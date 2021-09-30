package allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.CommonFunction;
import mainDriver.TestBase;

public class TransactionPage extends TestBase {
	CommonFunction commonfunction = new CommonFunction();
	@FindBy (xpath="//button[@ng-class='btnClass1']")
	public WebElement TransactionsButton;
	
	@FindBy (xpath="//button[@style='float:left']/../button[@class='btn']")
	public WebElement BackButton;
	
	@FindBy (xpath="//input[@id='start']")
	public WebElement TextBoxDatefirst;
	
	@FindBy (xpath="//input[@id='end']")
	public WebElement TextBoxDateLast;
	
	@FindBy (xpath="//a[@href='#']")
	public WebElement LinkDateTime;
	
	@FindBy (xpath="//a[contains(.,'Amount')]")
	public WebElement LinkAmount;
	
	@FindBy (xpath="//a[contains(.,'Transaction Type')]")
	public WebElement LinkTransactionType;
	
	@FindBy (xpath ="//button[@ng-show='showDate']")
	public WebElement ButtonReset;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	public WebElement NextPageButtonArrow;
	
	
	
	
	public TransactionPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnTransactionButton() {
		commonfunction.clickElement(TransactionsButton, "Transaction button is clicked");
		
	}
	
	public void validateTransactionPage() {
		commonfunction.isElementPresent(TextBoxDatefirst, "Starting Date Verified");
		commonfunction.isElementPresent(TextBoxDateLast, "Last Date Verified");
		commonfunction.isElementPresent(LinkDateTime, "Date and Time Link Verified");
		commonfunction.isElementPresent(LinkAmount, "Link Amount verified");
		commonfunction.isElementPresent(LinkTransactionType, "Transaction type verified");
		commonfunction.isElementPresent(ButtonReset, "Reset Button verified");
		commonfunction.isElementPresent(NextPageButtonArrow, "Next Page Button Arrow verified");
	}
}

