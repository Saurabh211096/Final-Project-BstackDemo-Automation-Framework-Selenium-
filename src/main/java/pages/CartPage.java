package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.WaitUtils;

public class CartPage {

	private WebDriver driver;
	
	private By cartItems = By.cssSelector(".float-cart__shelf-container .shelf-item");
	private By checkoutButton = By.cssSelector(".buy-btn");
	private By closeCartButton = By.cssSelector(".float-cart__close-btn");
	private By cartIcon = By.cssSelector(".bag__quantity");
	private By removeItemButton = By.cssSelector(".shelf-item__del");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getCartItemCount() {
		WaitUtils.waitForElementVisible(driver, driver.findElement(By.cssSelector(".float-cart__content")), 10);
		List<WebElement> items = driver.findElements(cartItems);
		return items.size();
	}
	public void clickCheckout() {
		WebElement checkoutBtn = WaitUtils.waitForElementClickable(driver, driver.findElement(checkoutButton), 10);
		checkoutBtn.click();
	}
	public void openCart() {
		WaitUtils.waitForElementClickable(driver, driver.findElement(cartIcon), 10).click();
	}
	public void closeCart() {
		WaitUtils.waitForElementClickable(driver, driver.findElement(closeCartButton), 10).click();
	}
	public String getCheckoutButtonText() {
		WebElement btn = WaitUtils.waitForElementVisible(driver, driver.findElement(checkoutButton), 10);
		return btn.getText();
	}
	public void removeItemFormCart() {
		WebElement removeBtn = WaitUtils.waitForElementClickable(driver, driver.findElement(removeItemButton), 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", removeBtn);
	}
}


















