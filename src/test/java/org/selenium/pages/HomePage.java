package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;

import com.selenium.components.MyHeader;
import com.selenium.components.ProductThumbNails;

public class HomePage extends BasePage {
	private MyHeader myHeader;
	private ProductThumbNails productThumbNails;
	
	public HomePage(WebDriver driver) {
		super(driver);
		myHeader=new MyHeader(driver);
		productThumbNails=	new ProductThumbNails(driver);
		
	}
	public MyHeader getMyHeader() {
		return myHeader;
	}
	public void setMyHeader(MyHeader myHeader) {
		this.myHeader = myHeader;
	}
	public ProductThumbNails getProductThumbNails() {
		return productThumbNails;
	}
	public void setProductThumbNails(ProductThumbNails productThumbNails) {
		this.productThumbNails = productThumbNails;
	}
	public HomePage load() throws IOException
	{
		load("/");
		return this;
	}
	
}
