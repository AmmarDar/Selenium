package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GetTitle {
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
  public void testGetTitle() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("ctl00_TopNavBar_QAAsk")).click();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_PostTitle")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_PostTitle")).sendKeys("Question about selenium ID and their using and how to use it in real life");
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_Content_MessageText")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_Content_MessageText")).sendKeys("<pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre>");
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_WhatHaveYouTried_MessageText")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_WhatHaveYouTried_MessageText")).sendKeys("<pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre>");
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_AttrChooser_FreeText")).clear();
    driver.findElement(By.id("ctl00_ctl00_MC_AMC_PostEntry_AttrChooser_FreeText")).sendKeys("java");
    driver.findElement(By.cssSelector("li.ac_even")).click();
    try {
      assertEquals("id=ctl00_Logo", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
