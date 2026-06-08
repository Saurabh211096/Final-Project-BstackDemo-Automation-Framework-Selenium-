package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		String browserName = ConfigReader.getProperty("browser");
		
		if (browserName != null && browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (System.getenv("GITHUB_ACTIONS") != null) {
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
			}
			
			driver = new ChromeDriver(options);
		} else if (browserName != null && browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName != null && browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigReader.getProperty("url"));
		
	}
	
//	@Test
//	public void trialTest() throws InterruptedException {
//		driver.findElement(By.id("signin")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.id("password")).click();
//		driver.findElement(By.id("react-select-3-input")).sendKeys("yobro");
//	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
