package org.selenium.api;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.selenium.objects.User;
import org.selenium.utils.ConfigLoader;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CartApi {
	private Cookies cookies;

	public Cookies getCookies() {
		return cookies;
	}
	public CartApi() {}
	public CartApi(Cookies cookies) {
		this.cookies=cookies;
	}
	public Response addToCart(int productId,int quantity) throws IOException
	{	HashMap<String, Object> formParams = new HashMap<String, Object>();
		formParams.put("product_sku","" );
		formParams.put("product_id", productId);
		formParams.put("quantity", quantity);
		
	
		Header header = new Header("content-type","application/x-www-form-urlencoded");
		Headers headers= new Headers(header);
		if(cookies==null)
		{
			cookies=  new Cookies();	
		}
		
	Response response=	given().baseUri(ConfigLoader.getInstance().getbaseURL()).headers(headers).formParams(formParams).cookies(cookies)
			.when().post("/?wc-ajax=add_to_cart").then().
			log().all().extract().response();
	if(response.getStatusCode()!=200)
	{
		throw new RuntimeException("Failed to registers http status code"+response.getStatusCode());
	}
	this.cookies=response.getDetailedCookies();
			
			return response;
		
	}
}
