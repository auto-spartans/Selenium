package firsttestngpackage;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P173MultWindowsDisplay {
	
	public static void display() {
		try	{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	public static void main (String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Launching the site
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(@href, 'popup.php')]")).click();
		
		String MainWindow = driver.getWindowHandle();
		
		//To handle all new opened windows
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		
		while (i1.hasNext()) {
			String ChildWindow=i1.next();
			if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
				//Switching to child window
				driver.switchTo().window(ChildWindow);
				display();
				driver.findElement(By.name("emailid"))
				.sendKeys("guarav.3n@gmail.com");
				display();
				
			driver.findElement(By.name("btnLogin")).click();
			display();
			
			//Closing the child window
			driver.close();
			}
		}
		//Switching to parent window (i.e. main window)
		driver.switchTo().window(MainWindow);
		display();
		driver.quit();
	}
}
