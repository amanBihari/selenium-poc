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

public class invalidLogin {
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
	  
	  @Test
	  public void testLoginPage() {
		String expectingError = "Invalid username or password."; 
	    // Find the text input element by its name
	    WebElement username = driver.findElement(By.id("username"));
	    // Clear the existing text value
	    username.clear();
	    username.sendKeys("aman");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    // Clear the existing text value
	    password.clear();
	    password.sendKeys("dNpVCP7tSFTy");

	    WebElement submitBtn = driver.findElement(By.id("kc-login"));

	    // Now submit the form
	    submitBtn.submit();

	    // Google's search is rendered dynamically with JavaScript.
	    // wait for the page to load, timeout after 10 seconds
	    
	    String errorText = driver.findElement(By.className("kc-feedback-text")).getText();
	    System.out.println(errorText);
	    
    	if(expectingError.equals(errorText))
          	System.out.println("The expected heading is same as actual heading --- "+errorText);
    	else
          	System.out.println("The expected heading doesn't match the actual heading --- "+errorText);
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    // Close the browser
	    driver.quit();
	  }

}
