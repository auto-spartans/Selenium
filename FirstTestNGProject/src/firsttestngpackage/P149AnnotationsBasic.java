package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class P149AnnotationsBasic 
{
	String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser()	{
		System.out.println("Launching browser...");
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}