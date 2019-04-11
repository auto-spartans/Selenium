package firsttestngpackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P157DateTimeNew {

	
public void display() {
	try	{
		Thread.sleep(1500);
	}
	catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
}
	
	@Test
		public void dateTimePicker() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/");

		//Find the date time picker control
		WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
//Fill date as mm/dd/yyyy as 09/25/2013
		dateBox.sendKeys("09252013");
		display();
//Press Tab to shift focus to the time field
		dateBox.sendKeys(Keys.TAB);
		display();
//Fill time as 02:45 PM
		dateBox.sendKeys("0245PM");
		display();
		
	driver.quit();	
	}
}
