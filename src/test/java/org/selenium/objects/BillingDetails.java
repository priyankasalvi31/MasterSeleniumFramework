package org.selenium.objects;

public class BillingDetails {
	private String billingFirstName;
	private String billingLastName;
	private String billingAddress_Line1;
	private String billingCity;
	private String billingPostalCode;
	private String billingEmail;
	private String billingState;
	private String billingCountry;
	public BillingDetails()
	{
		
	}
	public BillingDetails(String billingFirstName, String billingLastName, String billingAddress_Line1,
			String billingCity,String billingState,String billingCountry, String billingPostalCode, String billingEmail) {
		
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
		this.billingAddress_Line1 = billingAddress_Line1;
		this.billingCity = billingCity;
		this.billingState=billingState;
		this.billingCountry=billingCountry;
		this.billingPostalCode = billingPostalCode;
		this.billingEmail = billingEmail;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingFirstName() {
		return billingFirstName;
	}
	public BillingDetails setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
		return this;
	}
	public String getBillingLastName() {
		return billingLastName;
	}

	public BillingDetails setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
		return this;
	}
	public String getBillingAddress_Line1() {
		return billingAddress_Line1;
	}
	public BillingDetails setBillingAddress_Line1(String billingAddress_Line1) {
		this.billingAddress_Line1 = billingAddress_Line1;
		return this;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public BillingDetails setBillingCity(String billingCity) {
		this.billingCity = billingCity;
		return this;
	}
	
	public String getBillingPostalCode() {
		return billingPostalCode;
	}
	public BillingDetails setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
		return this;
	}
	public String getBillingEmail() {
		return billingEmail;
	}
	public BillingDetails setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
		return this;
	}
}
