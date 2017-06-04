package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddComment {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.codeproject.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddComment() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("ctl00_TopNavBar_QALatest")).click();
    driver.findElement(By.cssSelector("#ctl00_ctl00_MC_AMC_TabsCtrl_TabsRpt_ctl04_TL > span")).click();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_Entries_ctl01_QuestionRow_ArticleLink")).click();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_Content_MessageText")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_Content_MessageText")).sendKeys("Thanks");
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_AjaxSubmit")).click();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_Content_MessageText")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_Content_MessageText")).sendKeys("Thanks about the soloution it is useful");
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntryObj_AjaxSubmit")).click();
  }

  @After
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
