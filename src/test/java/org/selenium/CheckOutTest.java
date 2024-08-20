package org.selenium;

import java.io.IOException;

import org.selenium.api.CartApi;
import org.selenium.api.SignUpAPI;
import org.selenium.base.BaseTest;
import org.selenium.objects.BillingDetails;
import org.selenium.objects.Products;
import org.selenium.objects.User;
import org.selenium.pages.CheckOutPage;
import org.selenium.utils.FakerUtils;
import org.selenium.utils.JackSonutils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest{
	@Test(enabled=false)
	public void GuestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException
	{
		BillingDetails	billingDetails=	JackSonutils.deSerialize("myBillingAddress.json", BillingDetails.class);
		CheckOutPage checkOutPage = new CheckOutPage(getDriver()).load();
		Thread.sleep(5000);
		CartApi cartApi = new CartApi();
		Products product =new Products(1215);
		cartApi.addToCart(product.getId(), 1);
		injectCookiesToBrowser(cartApi.getCookies());
		checkOutPage.load().setBillingDetails(billingDetails).selectDirectBankTransfer().placeOrder();
		Thread.sleep(5000);
		Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
	}
	@Test(enabled=false)
	public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException
	{		BillingDetails	billingDetails=	JackSonutils.deSerialize("myBillingAddress.json", BillingDetails.class);
		User user = new User().setUsername("demouser"+ FakerUtils.generateName()).setPassword("dempowd").setEmail(FakerUtils.generateEmail());
		SignUpAPI signUpApi=	new SignUpAPI();
		signUpApi.register(user);
		System.out.println("REGISTER COOKIES "+signUpApi.getCookies());
		CartApi cartApi = new CartApi(signUpApi.getCookies());
		Products product =new Products(1215);
		cartApi.addToCart(product.getId(), 1);
		System.out.println("CART COOKIES "+cartApi.getCookies());
		CheckOutPage checkOutPage = new CheckOutPage(getDriver()).load();
		Thread.sleep(5000);
		injectCookiesToBrowser(signUpApi.getCookies());
		checkOutPage.load();
		
	//	checkOutPage.loginLbl().login(user.getUsername(),user.getPassword());
		Thread.sleep(5000);
		System.out.println(product.getName());
			Assert.assertTrue(checkOutPage.getProductName().contains(product.getName()));
			checkOutPage.load().setBillingDetails(billingDetails).selectDirectBankTransfer().placeOrder();
			Thread.sleep(5000);
			Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
			
			
	}
	
	@Test(enabled=true)
	public void loginAndCheckOutUsingDirectBankTransfer_temporary() throws InterruptedException, IOException
	{		BillingDetails	billingDetails=	JackSonutils.deSerialize("myBillingAddress.json", BillingDetails.class);
	User user = new User().setUsername("demouser"+ FakerUtils.generateName()).setPassword("dempowd").setEmail(FakerUtils.generateEmail());
	SignUpAPI signUpApi=	new SignUpAPI();
	signUpApi.register(user);
	Thread.sleep(5000);
	System.out.println("REGISTER COOKIES "+signUpApi.getCookies());
	CartApi cartApi = new CartApi();
	Products product =new Products(1215);
	cartApi.addToCart(product.getId(), 1);
	System.out.println("CART COOKIES "+cartApi.getCookies());
	CheckOutPage checkOutPage = new CheckOutPage(getDriver()).load();
	Thread.sleep(5000);
	injectCookiesToBrowser(cartApi.getCookies());
	checkOutPage.load();
	Thread.sleep(5000);
	checkOutPage.loginLbl().login(user.getUsername(),user.getPassword());
	Thread.sleep(5000);
	System.out.println(product.getName());
		Assert.assertTrue(checkOutPage.getProductName().contains(product.getName()));		
	
		System.out.println(product.getName());
			Assert.assertTrue(checkOutPage.getProductName().contains(product.getName()));
			checkOutPage.setBillingDetails(billingDetails).selectDirectBankTransfer().placeOrder();
			Thread.sleep(5000);
			Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
			
			
	}
}
