package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class ProductPage {

	private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addProductToCart(String productName) {
		String productXPath = "//p[text()='" + productName + "']/ancestor::div[contains(@class,'shelf-item')]//div[contains(@class,'shelf-item__buy-btn')]";
		
		WebElement addToCartBtn = WaitUtils.waitForElementClickable(driver, driver.findElement(By.xpath(productXPath)), 10);
		addToCartBtn.click();
	}
	
}
