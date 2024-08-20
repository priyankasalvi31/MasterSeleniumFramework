package org.selenium.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.constants.*;

public class DriverManager {
	
	public WebDriver intializeDriver(String browser)
	{		 WebDriver driver;
	//String localBrowser	=browser;
	

	switch(browser)
	{
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\chromedriver\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
					
		case "firefox":		
		
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\firefoxdriver\\geckodriver.exe");
					driver = new FirefoxDriver();
					break;
		default:
			throw new IllegalStateException("INVALID BROWSER");
		
	}
//	System.setProperty("webdriver.chrome.driver",
//			"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\firefoxdriver\\gecko.exe");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

}
