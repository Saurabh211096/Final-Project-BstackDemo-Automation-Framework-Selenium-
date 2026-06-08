package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void testValidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.login(ConfigReader.getProperty("username")
				, ConfigReader.getProperty("password"));
		
		String actualUsername = loginPage.getLoggedInUsername();
		String expectedUsername = ConfigReader.getProperty("username");
		
		Assert.assertEquals(actualUsername, expectedUsername
				, "Login failed: Usernames do not match!");
	}
	@Test(priority = 2) 
	public void testInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		loginPage.login(ConfigReader.getProperty("lockeduser")
				, ConfigReader.getProperty("password"));
		String errorText = loginPage.getLoginErrorMessage();
		Assert.assertEquals(errorText, "Your account has been locked."
				, "Bug: Invalid login error message mismatch!");
	}
	@Test(priority = 3)
	public void testEmptyCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
		
		loginPage.clickLoginBtn();
		
		String errorText = loginPage.getLoginErrorMessage();
		Assert.assertEquals(errorText, "Invalid Username"
				, "Bug: Empty login did not trigger the correct error!");
	}
}

















