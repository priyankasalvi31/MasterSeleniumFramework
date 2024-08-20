package org.selenium;

import java.io.IOException;

import org.selenium.base.BaseTest;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
	
	@Test(enabled=true)
	public void NavigateFromHomeToStoreMenu() throws InterruptedException, IOException
	{
		
		StorePage storePage = new HomePage(getDriver()).load().getMyHeader().clickStoreMenuLink();
		Assert.assertEquals(storePage.getTitle(), "Store");
}
}