package com.automate.withMe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BeforeAfterTest {
	WebDriver driver=null;
	
	  @BeforeTest
	  @Parameters({"Browser"})
	  public void beforeTest(String browser) {
		  if(browser.equalsIgnoreCase("chrome")){
			//Driver exe config
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\chromedriver.exe");
				
				//Instansiation the WebDriver Instance
				 driver = new ChromeDriver();
				
		  }
		  else if(browser.equalsIgnoreCase("IE")){
			  System.setProperty("webdriver.ie.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\IEDriverServer.exe");
				 driver= new InternetExplorerDriver();
		  }
		  else if(browser.equalsIgnoreCase("Headless")){
			  WebDriver driver = new HtmlUnitDriver();
		  }
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
		  driver.quit();
	  }

}