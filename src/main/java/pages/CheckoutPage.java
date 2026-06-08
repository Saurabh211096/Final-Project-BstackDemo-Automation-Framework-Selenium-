package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {
	
	private WebDriver driver;

	private By firstNameInput = By.id("firstNameInput");
	private By lastNameInput = By.id("lastNameInput");
	private By addressInput = By.id("addressLine1Input");
	private By stateInput = By.id("provinceInput");
	private By postalCodeInput = By.id("postCodeInput");
	private By submitButton = By.id("checkout-shipping-continue");
	
	private By orderConfirmationMessage = By.id("confirmation-message");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterShippingDetailsAndSubmit(String fName, String lName
			, String address, String state, String zip) {
		
		WaitUtils.waitForElementVisible(driver, driver.findElement(firstNameInput), 10).sendKeys(fName);
		driver.findElement(lastNameInput).sendKeys(lName);
		driver.findElement(addressInput).sendKeys(address);
		driver.findElement(stateInput).sendKeys(state);
		driver.findElement(postalCodeInput).sendKeys(zip);
		
		WaitUtils.waitForElementClickable(driver, driver.findElement(submitButton), 10).click();
	}
	public boolean isOrderConfirmed() {
		try {
			return WaitUtils.waitForElementVisible(driver, driver.findElement(orderConfirmationMessage), 10).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}














