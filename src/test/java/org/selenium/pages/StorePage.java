package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;

import com.selenium.components.MyHeader;
import com.selenium.components.ProductThumbNails;

public class StorePage extends BasePage {

	private final By searchFld = By.cssSelector("#woocommerce-product-search-field-0");
	private final By searchBtn = By.cssSelector("button[value='Search']");
	private final By title =By.cssSelector(".woocommerce-products-header__title.page-title");
	private ProductThumbNails productThumbNails; 
	private MyHeader myHeader;
	public MyHeader getMyHeader() {
		return myHeader;
	}



	public void setMyHeader(MyHeader myHeader) {
		this.myHeader = myHeader;
	}



	public StorePage(WebDriver driver) {
		super(driver);
		productThumbNails=new ProductThumbNails(driver);
		myHeader=new MyHeader(driver);
	}
	
	
	
	public ProductThumbNails getProductThumbNails() {
		return productThumbNails;
	}



	public void setProductThumbNails(ProductThumbNails productThumbNails) {
		this.productThumbNails = productThumbNails;
	}



	public StorePage Search(String txt)
	{	driver.findElement(searchFld).sendKeys(txt);
		driver.findElement(searchBtn).click();
		return this;
	}
	

	public StorePage load() throws IOException
	{	load("/store");
		return this;
	}
	
	public String getTitle()
	{
	return	driver.findElement(title).getText();
		
	}
	
	

}
