package org.selenium.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	
	public static long generateName()
	{
		Faker faker = new Faker();
		return faker.number().randomNumber();
	}
	
	public static String generateEmail()
	{
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}
}
