package org.selenium.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private final Properties properties;
	private static ConfigLoader configloader;
	
	private ConfigLoader() throws IOException
	{
		properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
			}
	public static ConfigLoader getInstance() throws IOException
	{
		if(configloader==null)
		{
			configloader =new ConfigLoader();
		}
		return configloader;
	}
	
	public String getbaseURL()
	{
		String prop =properties.getProperty("baseURL");
		if(prop!=null)
			return prop;
		else
			throw new RuntimeException("property baseURL is not specified in the config.properties");
	}
	public String getUserName()
	{
		String username =properties.getProperty("username");
		if(username!=null)
			return username;
		else
			throw new RuntimeException("property username is not specified in the config.properties");
	}
	public String getPassWord()
	{
		String password =properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("property password is not specified in the config.properties");
	}
}
	
	
