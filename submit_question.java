package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class submit_question {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.codeproject.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void test1() throws Exception {
		selenium.open("/");
		selenium.click("id=ctl00_TopNavBar_QAAsk");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=ctl00_ctl00_MC_AMC_PostEntry_PostTitle", "Question about selenium ID and their using and how to use it in real life");
		selenium.type("id=ctl00_ctl00_MC_AMC_PostEntry_Content_MessageText", "<pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre>");
		selenium.type("id=ctl00_ctl00_MC_AMC_PostEntry_WhatHaveYouTried_MessageText", "<pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre><pre>Question about selenium ID and their using and how to use it in real life</pre>");
		selenium.type("id=ctl00_ctl00_MC_AMC_PostEntry_AttrChooser_FreeText", "java");
		selenium.click("css=li.ac_even");
		selenium.click("id=ctl00_ctl00_MC_AMC_PostEntry_Submit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
