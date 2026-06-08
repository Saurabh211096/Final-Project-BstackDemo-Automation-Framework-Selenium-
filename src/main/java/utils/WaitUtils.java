package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	// Helper method to ensure an element is visible before we 
	// interact with it
	public static WebElement waitForElementVisible(WebDriver driver
			, WebElement element, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver
				, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Helper method to ensure an element is clickable
	public static WebElement waitForElementClickable(WebDriver driver
			, WebElement element, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver
				, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
