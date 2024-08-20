package org.selenium.utils;

import java.io.IOException;
import java.io.InputStream;

import org.selenium.objects.BillingDetails;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackSonutils {
	
	public static <T> T deSerialize(String filePath,Class<T> T) throws IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		InputStream is =JackSonutils.class.getClassLoader().getResourceAsStream(filePath);
	return	objectMapper.readValue(is, T);
		
	}

}
