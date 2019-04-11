package firsttestngpackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class P200ExplicitWait {

	protected WebDriver driver;

	@Test
	public void guru99tutorials() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String eTitle = "Demo Guru99 Page";
		String aTitle = "";
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		aTitle = driver.getTitle();
		if (aTitle.contentEquals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		WebElement guru99seleniumLink;
		guru99seleniumLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rt-feature\"]/div/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/h4/a")));
		guru99seleniumLink.click();
		driver.quit();
	}
}
