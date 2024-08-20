package org.selenium;

import java.io.IOException;

import org.selenium.base.BaseTest;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest  extends BaseTest {

	@Test(enabled=true)
	public void SearchTestwithPartialMatch() throws InterruptedException, IOException
	{
		String searchFor="Blue";
		StorePage storePage = new StorePage(getDriver()).load().Search(searchFor);
		Assert.assertEquals(storePage.getTitle(),  "Search results: “"+searchFor+"”");
}

}
