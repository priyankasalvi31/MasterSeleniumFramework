package org.selenium.objects;

import java.io.IOException;

import org.selenium.utils.JackSonutils;

public class Products {
	
	private int id;
	private String name;
	
	public Products()
	{}
	
	public Products(int id) throws IOException
	{
		Products[] products=	JackSonutils.deSerialize("products.json", Products[].class);
		for(Products Product:products)
		{
			if(Product.getId()==id)
			{
				this.id=id;
				this.name=Product.getName();
			}
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
