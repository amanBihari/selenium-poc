package com.seleniumcookbook.examples.chapter01;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class LoginSacada {
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
	    // Find the text input element by its name
	    WebElement username = driver.findElement(By.id("username"));
	    // Clear the existing text value
	    username.clear();
	    username.sendKeys("iiqtest");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    // Clear the existing text value
	    password.clear();
	    password.sendKeys("dNpVCP7tSFTy");

	    WebElement submitBtn = driver.findElement(By.id("kc-login"));

	    // Now submit the form
	    submitBtn.submit();
	    
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	    boolean mapElement = driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']")).isDisplayed();
	    
	    if(mapElement)
          	System.out.println("The map is present on UI.");
    	else
    		System.out.println("The map is not present on UI.");
	    
	    boolean tableElement = driver.findElement(By.xpath("//div[@class='ag-root-wrapper-body ag-layout-normal ag-focus-managed']")).isDisplayed();
	    
	    if(mapElement)
          	System.out.println("The table is present on UI.");
    	else
    		System.out.println("The table is not present on UI.");
	    	
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    // Close the browser
	    driver.quit();
	  }

}
