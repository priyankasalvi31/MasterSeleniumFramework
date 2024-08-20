package org.selenium;

import java.io.IOException;

import org.selenium.base.BaseTest;
import org.selenium.dataprovider.MyDataProvider;
import org.selenium.objects.Products;
import org.selenium.pages.CartPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{
	

	@Test(enabled=true)
	public void addToCartFromStorePage() throws InterruptedException, IOException
	{
	
		Products products = new Products(1215);
		CartPage cartPage = new StorePage(getDriver()).load().getProductThumbNails()
		.clickAddToCartBtn(products.getName())
		.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), products.getName());

}
	
	@Test(enabled=true,dataProvider = "getFeaturedProducts",dataProviderClass = MyDataProvider.class)
	public void addToCartFeaturedProducts(Products products) throws InterruptedException, IOException
	{
		CartPage cartPage= new HomePage(getDriver()).load().getProductThumbNails().
						   clickAddToCartBtn(products.getName()).clickViewCart();
		Assert.assertEquals(cartPage.getProductName(),products.getName());
}

	
}
