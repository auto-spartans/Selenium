package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class P152AnnotationsMore {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;
	public String expected = null;
	public String actual = null;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching browser...");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); //Assert statement.
	}

	@Test(priority = 0)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click();
		expected = "Under Construction: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void goBackToHomepage() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}