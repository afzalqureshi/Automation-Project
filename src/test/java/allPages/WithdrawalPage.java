package allPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawalPage {
	
	@FindBy (xpath="//button[@ng-class='btnClass3']")
	public WebElement WithdrawalButton;
	
	@FindBy (xpath ="//input[@type='number']")
	public WebElement WithdrawalAmountBox;
	
	@FindBy (xpath ="//button[@type='submit']")
	public WebElement WithdrawalButton2;

}
