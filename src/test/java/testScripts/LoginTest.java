package testScripts;

import org.testng.annotations.Test;

import allPages.LoginPage;
import mainDriver.TestBase;

public class LoginTest extends TestBase{
	@Test
	public void loginTestCase() {
		LoginPage loginpage= new LoginPage();
		loginpage.clickOnCustomerLoginButton();
		loginpage.selectUserName();
		loginpage.clickLoginButton();
		loginpage.checkLoggedInUserName();
		loginpage.clickLogoutButton();
	}

}
