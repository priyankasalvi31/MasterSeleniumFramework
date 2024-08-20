package com.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.base.BasePage;
import org.selenium.pages.StorePage;

public class MyHeader extends BasePage{
	
	public MyHeader(WebDriver driver) {
		super(driver);

	}
	
	private final By storeMenuLink =By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
	
	
	public StorePage clickStoreMenuLink()
	{
		driver.findElement(storeMenuLink).click();
		return new StorePage(driver);
		
	}

}

