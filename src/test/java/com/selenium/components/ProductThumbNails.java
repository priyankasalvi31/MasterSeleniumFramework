package com.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;
import org.selenium.base.BaseTest;
import org.selenium.pages.CartPage;
import org.selenium.pages.StorePage;

public class ProductThumbNails extends BasePage{
	
	public ProductThumbNails(WebDriver driver) {
		super(driver);
		
	}
	
	private final By viewCartLink =By.cssSelector("a[title='View cart']");
	private By getAddToCartBtnElement(String productName)
	{
		return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
	}
	public ProductThumbNails clickAddToCartBtn(String productName) throws InterruptedException
	{
		By addToCartBtn= getAddToCartBtnElement(productName);

	wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		driver.findElement(addToCartBtn).click();
		
		return this;
		
	}
	
	public CartPage clickViewCart() throws InterruptedException
	{ Thread.sleep(2000);
		driver.findElement(viewCartLink).click();
		return new CartPage(driver);
		
	}
}
