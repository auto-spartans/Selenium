package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PXXXCrossBrowserScript {
	WebDriver driver;

	/* This function will execute before each Test tag in testng.xml */

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Firefox
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Chrome
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Edge
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		// IE
		else if (browser.equalsIgnoreCase("internet explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Browser is not correct.");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.get("http://demo.guru99.com/V4/");
		WebElement userName = driver.findElement(By.name("uid"));
		userName.sendKeys("guru99");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("guru99");
	}
}
