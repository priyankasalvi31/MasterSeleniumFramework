package org.selenium.base;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utils.ConfigLoader;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForOverLaysToDisappear(By overlay)
	{
		List<WebElement> overLays= driver.findElements(overlay);
		System.out.println("OVERLAY SIZE " +overLays.size());
		if(overLays.size()>0)
		{
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overLays));
		System.out.println("OVERLAYS VISIBLE");
		}
		
		else
		{
			System.out.println("OVERLAYS INVISIBLE");
		}
	}
	
	public WebElement getElement(By element)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void load(String endPoint) throws IOException
	{
		driver.get(ConfigLoader.getInstance().getbaseURL()+endPoint);
	}

}
