package com.selenium.factoryDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager implements DriverManager {

	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Priyanka\\OneDrive\\Desktop\\Trainings\\chrome\\firefoxdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				return driver;
				
	}



}
