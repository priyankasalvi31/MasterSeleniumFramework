package com.selenium.abstractfactory;

import org.selenium.constants.DriverTypes;

public class DriverManagerFactoryAbstract {
	
	public static DriverManagerAbstract getManager(DriverTypes driverTypes)
	{
		switch(driverTypes)
		{
		case CHROME: 
			return	new ChromeDriverManagerAbstract();
		case FIREFOX: 	
			return	new FireFoxDriverManagerAbstract();
		default:
			throw new IllegalStateException("INVALID BROWSER " +driverTypes);
			
		}
	
	}

}
