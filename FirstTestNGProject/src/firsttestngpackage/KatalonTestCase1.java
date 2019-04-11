package firsttestngpackage;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonTestCase1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    //baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://demo.guru99.com/test/login.html");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("abcdefghijkl");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
    assertEquals(driver.findElement(By.id("email")).getAttribute("value"), "abcd@gmail.com");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("abcdefghijkl");
    assertEquals(driver.findElement(By.id("passwd")).getAttribute("value"), "abcdefghijkl");
    driver.findElement(By.id("SubmitLogin")).click();
    driver.get("http://demo.guru99.com/test/radio.html");
    assertEquals(driver.getTitle(), "Radio Button & Check Box Demo");
    driver.findElement(By.id("vfb-7-1")).click();
    driver.findElement(By.id("vfb-7-2")).click();
    driver.findElement(By.id("vfb-6-0")).click();
    driver.get("http://demo.guru99.com/test/facebook.html");
    driver.findElement(By.id("persist_box")).click();
    assertTrue(driver.findElement(By.id("persist_box")).isSelected());
    driver.findElement(By.id("persist_box")).click();
    assertFalse(driver.findElement(By.id("persist_box")).isSelected());
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}