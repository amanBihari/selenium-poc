package com.seleniumcookbook.examples.chapter01;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

public class commonStep {
	
	private WebDriver driver;
	
	  @Before
	  public void setUp() {
		  System.setProperty("webdriver.chrome.driver", "/usr/local/share/selenium-webdriver/chromedriver");
	    // Launch a new Firefox instance
	    driver = new ChromeDriver();
	    // Maximize the browser window
	    driver.manage().window().maximize();
	    // Navigate to Google
	    driver.get("https://arbtest.iron-iq.com/#/scada");
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    // Close the browser
	    driver.quit();
	  }

}
