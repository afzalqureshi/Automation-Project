package allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.CommonFunction;
import mainDriver.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="(//button[@class='btn btn-primary btn-lg'])[position()=1]")
	public WebElement customerLoginButton;

	@FindBy (xpath="(//button[@class='btn btn-primary btn-lg'])[position()=2]")
	public WebElement bankManagerLoginButton;

	@FindBy (xpath="//select[@class='form-control ng-pristine ng-valid ng-touched']")
	public WebElement yourNamePullDown;

	@FindBy (xpath="//button[@class='btn btn-default']")
	public WebElement loginButton;

	@FindBy (xpath="//div/strong[contains(.,'Welcome')]/span[contains(.,'Harry Potter')]")
	public WebElement titleOfPage;

	@FindBy (xpath="//button[@ng-class='btnClass1']")
	public WebElement transactionsButton;

	@FindBy (xpath="//button[@ng-class='btnClass2']")
	public WebElement depositButton;

	@FindBy (xpath="//button[@ng-class='btnClass3']")
	public WebElement withdrawalButton;

	@FindBy (xpath ="//button[@ng-show='logout']")
	public WebElement logoutButton;

	@FindBy (id="userSelect")
	public WebElement userNameDropDown;

	CommonFunction commonfunction =new CommonFunction();
	public LoginPage() {
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
		//this is to say initialize current class
		//instead of this, we can also use classname.class
	}
	public void clickOnCustomerLoginButton() {
		commonfunction.clickElement(customerLoginButton, "Customer Login Button");
		CommonFunction.waitforfivesecond();

	}
	public void selectUserName() {
		commonfunction.selectDropdownByVisibleText(userNameDropDown, "Harry Potter", "Username dropdown value Harry Potter selected");
		CommonFunction.waitforfivesecond();
	}
	
	public void clickLoginButton() {
		commonfunction.clickElement(loginButton, "Login Button is clicked");
		CommonFunction.waitforfivesecond();
	}

	public void checkLoggedInUserName() {
		commonfunction.isElementPresent(titleOfPage, "Verify if selection is correct");
		CommonFunction.waitforfivesecond();
	}
	public void clickLogoutButton() {
		commonfunction.clickElement(logoutButton, "Logout Button is clicked");
		CommonFunction.waitforfivesecond();
	}
}
