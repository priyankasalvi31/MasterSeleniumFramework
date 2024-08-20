package org.selenium.api;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.objects.User;
import org.selenium.utils.ConfigLoader;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class SignUpAPI {

	private Cookies cookies;

	public Cookies getCookies() {
		return cookies;
	}
public String fetchRegisterNonceValueUsingGroovy() throws IOException
{
	Response response =getAccount();
	return response.htmlPath().getString("**.findAll { it.@name=='woocommerce-register-nonce'}.@value");

}

public String fetchRegisterNonceValueUsingJsoup() throws IOException
{
	Response response =getAccount();

	Document document = Jsoup.parse(response.body().prettyPrint());
	Element element =document.selectFirst("#woocommerce-register-nonce");
	return element.attr("value");

}
	public Response register(User user) throws IOException
	{	HashMap<String, String> formParams = new HashMap<String, String>();
		formParams.put("username", user.getUsername());
		formParams.put("password", user.getPassword());
		formParams.put("email", user.getEmail());
		formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingGroovy());
		formParams.put("register", "Register");
		Cookies cookies=  new Cookies();
		Header header = new Header("Content-Type","application/x-www-form-urlencoded");
		Headers headers= new Headers(header);
		
	Response response=	given().baseUri(ConfigLoader.getInstance().getbaseURL()).headers(headers).formParams(formParams).cookies(cookies)
			.when().post("/account").then().
			log().all().extract().response();
	if(response.getStatusCode()!=302)
	{
		throw new RuntimeException("Failed to registers http status code"+response.getStatusCode());
	}
	this.cookies=response.getDetailedCookies();
			
			return response;
		
	}
	public Response getAccount() throws IOException
	{Cookies cookies=  new Cookies();
		
		Header header = new Header("Content-Type","application/x-www-form-urlencoded");
		Headers headers= new Headers(header);
	Response response=	given().baseUri(ConfigLoader.getInstance().getbaseURL()).cookies(cookies)
			.when().get("/account").then().
			log().all().extract().response();
	if(response.getStatusCode()!=200)
	{
		throw new RuntimeException("Failed to fetch http status code"+response.getStatusCode());
	}
	return response;
		
	}
}
