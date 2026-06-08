package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

	@Test(priority = 2)
	public void testAddSingleItemToCart() {
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);

		productPage.addProductToCart("iPhone 12");

		int cartCount = cartPage.getCartItemCount();
		Assert.assertEquals(cartCount, 1
				, "Cart count mismatch after adding 1 item!");
	}
	@Test(priority = 3)
	public void testAddMultipleItemsToCart() {
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		productPage.addProductToCart("iPhone 12");
		
		cartPage.closeCart();
		
		productPage.addProductToCart("One Plus 6T");
		
		int cartCount = cartPage.getCartItemCount();
		Assert.assertEquals(cartCount, 2
				, "Cart count mismatch after adding 2 items!");
	}
	@Test(priority = 4)
	public void testRemoveItemFromCart() {
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		productPage.addProductToCart("iPhone 12");
		cartPage.removeItemFormCart();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int cartCount = cartPage.getCartItemCount();
		Assert.assertEquals(cartCount, 0
				, "Bug: Item was not removed from the cart!");
	}
}












