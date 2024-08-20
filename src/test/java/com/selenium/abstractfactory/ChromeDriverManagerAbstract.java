package com.selenium.abstractfactory;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManagerAbstract extends DriverManagerAbstract {
 
	

	@Override
	protected void startDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}

	
		
	}
	
	


