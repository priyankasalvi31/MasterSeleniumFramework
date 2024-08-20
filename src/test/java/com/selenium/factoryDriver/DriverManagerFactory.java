package com.selenium.factoryDriver;

import org.selenium.constants.DriverTypes;

public class DriverManagerFactory {
	
	public static DriverManager getManager(DriverTypes driverTypes)
	{
		switch(driverTypes)
		{
		case CHROME: 
			return	new ChromeDriverManager();
		case FIREFOX: 	
			return	new FireFoxDriverManager();
		default:
			throw new IllegalStateException("INVALID BROWSER " +driverTypes);
			
		}
	
	}

}
