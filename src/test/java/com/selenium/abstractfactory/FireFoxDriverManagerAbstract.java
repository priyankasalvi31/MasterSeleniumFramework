package com.selenium.abstractfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManagerAbstract extends DriverManagerAbstract {

	

	@Override
	protected void startDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\firefoxdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}



}
