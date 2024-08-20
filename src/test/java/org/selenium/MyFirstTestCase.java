package org.selenium;

import java.io.IOException;

import org.selenium.base.BaseTest;
import org.selenium.objects.BillingDetails;
import org.selenium.objects.Products;
import org.selenium.objects.User;
import org.selenium.pages.CartPage;
import org.selenium.pages.CheckOutPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.JackSonutils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {
	@Test(enabled=true)
	public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException
	{
		String searchFor="Blue";
	
		BillingDetails	billingDetails=	JackSonutils.deSerialize("myBillingAddress.json", BillingDetails.class);
		Products products = new Products(1215);
		StorePage storePage = new HomePage(getDriver()).load().getMyHeader().
				clickStoreMenuLink().Search(searchFor);
		Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”");
		
		storePage.getProductThumbNails()
		.clickAddToCartBtn(products.getName());
		
		CartPage cartPage = storePage.getProductThumbNails().clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), products.getName());
		CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();
		
		
		checkOutPage.setBillingDetails(billingDetails).selectDirectBankTransfer();
		checkOutPage.placeOrder();
		Thread.sleep(5000);
		Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");

	}

	
	@Test(enabled=true)
	public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException
	{	String searchFor="Blue";
		BillingDetails	billingDetails=	JackSonutils.deSerialize("myBillingAddress.json", BillingDetails.class);
		Products products = new Products(1215);
		StorePage storePage = new HomePage(getDriver()).load().getMyHeader().clickStoreMenuLink().Search(searchFor);
	//	Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”");
		
		storePage.getProductThumbNails().clickAddToCartBtn(products.getName());
		CartPage cartPage = storePage.getProductThumbNails().clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), products.getName());
		CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();
		User user = new User(ConfigLoader.getInstance().getUserName(),ConfigLoader.getInstance().getPassWord());
		
		checkOutPage.loginLbl().
		login(user.getUsername(),user.getPassword());
	
		checkOutPage.setBillingDetails(billingDetails);
		checkOutPage.placeOrder();
		
		Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");

	}

}
