package firsttestngpackage;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P160DateTimeAdv {

	@Test
	public void testDatePicker() throws Exception{
		//Date and Time to be set in textbox.
		String dateTime="12/07/2014 2:00 PM";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		
		
		//Dismiss the new "cookies" window
		WebElement acceptCookies = driver.findElement(By.xpath("//a[@class='optanon-allow-all']"));
		acceptCookies.click();
		
		//Button to open calendar
		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();
		
		//Button to move next in calendar
		WebElement nextLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class, 'k-nav-next')]"));
		
		//Button to click in center of calendar header
		WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class, 'k-nav-fast')]"));
		
		//Button to move to previous month in calendar
		WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class, 'k-nav-prev')]"));
		
		//Split the date time to get only the date part
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
		
		//Get the year difference between current year and year to set in calendar
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])-Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();
		
		if(yearDiff!=0) {
			//if you have to move to next year
			if(yearDiff>0) {
				for(int i=0; i<yearDiff; i++) {
					System.out.println("Year Diff->"+i);
					nextLink.click();
				}
			}
//if you have to move to previous year
			else if(yearDiff<0) {
				for(int i=0;i<(yearDiff*(-1));i++) {
					System.out.println("Year Diff->"+i);
					previousLink.click();
				}
			}
		}
		Thread.sleep(1000);
		
		//Get all months from calendar to select correct one
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class, 'k-other-month'))]"));
		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
		Thread.sleep(1000);
		
		//Get all dates from calendar to select correct one
		List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class, 'k-other-month'))]"));
		list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

		//FOR TIME
		WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
		
		//click time picker button
		selectTime.click();
		
		//get list of times
		List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style, 'display: block')]//ul//li[@role='option']"));
		String desiredTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];
	
		//select correct time
		for (WebElement webElement : allTime) { //NOTE TO SELF: The colon ":" here is an Enhanced For Loop, allowing me to pass-in a List/Array ("allTime", in this case).
			if(webElement.getText().equalsIgnoreCase(desiredTime))
			{
				webElement.click();
			}
		}
		driver.quit();	
	}
}