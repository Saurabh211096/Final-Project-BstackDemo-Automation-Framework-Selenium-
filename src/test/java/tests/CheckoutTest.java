package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

	@Test(priority = 1)
	public void testValidCheckout() {
		
		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		loginPage.clickSignIn();
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		productPage.addProductToCart("iPhone 12");
		
		cartPage.clickCheckout();
		
		checkoutPage.enterShippingDetailsAndSubmit("John", "Doe", "123 Automation Way", "New York", "100001");
		
		Assert.assertTrue(checkoutPage.isOrderConfirmed()
				, "Checkout failed: Order confirmation message not displayed!");
	}
	
	@Test(priority = 2)
	public void testEmptyCartCheckout() {
		
		CartPage cartPage = new CartPage(driver);
		
		cartPage.openCart();
		
		String actualButtonText = cartPage.getCheckoutButtonText();
		
		Assert.assertEquals(actualButtonText, "CONTINUE SHOPPING"
				, "Bug: The button text did not change on an empty cart!");
		
	}
}
