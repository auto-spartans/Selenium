package firsttestngpackage;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OlsonsDesign1 {
	
	@Test
	public void QuickTest() {
		//Launch Firefox
		ProfilesIni profilef = new ProfilesIni();
		FirefoxProfile myprofile = profilef.getProfile("Autotest");
		FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);
		WebDriver driver = new FirefoxDriver(options);

		/*//Launch Chrome [!CLOSE ALL CHROME WINDOWS BEFORE RUNNING!]
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\Brandon\\AppData\\Local\\Google\\Chrome\\User Data\\");
		options.addArguments("profile-directory=Profile 2");
		WebDriver driver = new ChromeDriver(options);*/

		//Actual Test
		driver.get("https://olsonsdesign.com");
		String expected = "CSS Inheritance";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		driver.close();
}
	
}