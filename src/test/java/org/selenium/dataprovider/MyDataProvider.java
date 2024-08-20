package org.selenium.dataprovider;

import java.io.IOException;

import org.selenium.objects.Products;
import org.selenium.utils.JackSonutils;
import org.testng.annotations.DataProvider;

public class MyDataProvider {
	@DataProvider(name ="getFeaturedProducts",parallel=true)
	public Object[] getFeaturedProducts() throws IOException
	{
		return JackSonutils.deSerialize("products.json", Products[].class);
	}
}
