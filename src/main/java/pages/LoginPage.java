package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

	private WebDriver driver;
	
	private By signInLink = By.id("signin");
	
	private By usernameBox = By.id("username");
	private By usernameInput = By.id("react-select-2-input");
	private By passwordBox = By.id("password");
	private By passwordInput = By.id("react-select-3-input");
	private By loginButton = By.id("login-btn");
	private By loggedInUsername = By.className("username");
	private By errorMessage = By.className("api-error");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignIn() {
		WaitUtils.waitForElementClickable(driver
				, driver.findElement(signInLink), 10).click();
	}
	public void login(String username, String password) {
		WaitUtils.waitForElementVisible(driver, driver.findElement(usernameInput), 10);
		driver.findElement(usernameInput).sendKeys(username + Keys.ENTER);
		
		driver.findElement(passwordInput).sendKeys(password + Keys.ENTER);
		WaitUtils.waitForElementClickable(driver, driver.findElement(loginButton), 10).click();
	}
	public String getLoggedInUsername() {
		WaitUtils.waitForElementVisible(driver, driver.findElement(loggedInUsername), 10);
		return driver.findElement(loggedInUsername).getText();
	}
	public String getLoginErrorMessage() {
		return WaitUtils.waitForElementVisible(driver, driver.findElement(errorMessage), 10).getText();
	}
	public void clickLoginBtn() {
		WaitUtils.waitForElementVisible(driver, driver.findElement(loginButton), 10).click();
	}
}














