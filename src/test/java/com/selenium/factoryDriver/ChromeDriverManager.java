package com.selenium.factoryDriver;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements DriverManager {
 
	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

	
		
	}
	
	


