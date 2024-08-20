package org.selenium.api;

import java.io.IOException;

import org.selenium.objects.User;
import org.selenium.utils.FakerUtils;

public class DummyApi {

	public static void main(String[] args) throws IOException {
		User user = new User().setUsername("demouser"+ FakerUtils.generateName()).setPassword("dempowd").setEmail(FakerUtils.generateEmail());
		SignUpAPI signUpApi=	new SignUpAPI();
		signUpApi.register(user);
		System.out.println("REGISTER COOKIES "+signUpApi.getCookies());
		CartApi cartApi = new CartApi(signUpApi.getCookies());
		cartApi.addToCart(1215, 1);
		System.out.println("CART COOKIES "+cartApi.getCookies());
		}

}
