package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFileErrors {
	  public String baseUrl = "http://demo.guru99.com/test/newtours/";
	  String driverPath = "C:\\chromedriver.exe";
	  public WebDriver driver;
	  
		@Test
	  public void verifyHomepageTitle() {
			System.out.println("Launching Chrome browser...");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			String expectedTitle = "Welcome: Mercury Tours";
			String actualTitle = driver.getTitle();
			try { //This is supposed to be an error, but the test will keep going.
			      driver.switchTo().alert();
			    } catch (NoAlertPresentException e) {
			    }
			Assert.assertEquals(actualTitle,  expectedTitle);
			Assert.assertEquals(actualTitle, "4"); //This will cause the Test to end.
			driver.close(); //This step will not be run.
	  }
}