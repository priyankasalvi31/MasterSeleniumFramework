package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;
import org.selenium.objects.BillingDetails;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".showlogin") private WebElement loginLbl;
	
	
	private final By showOverLay=By.cssSelector(".blockUI.blockOverlay");
	private final By userNameFld=By.xpath("//input[@id='username']");
	private final By passwordFld=By.cssSelector("#password");
	private final By loginBtn=By.cssSelector("button[value='Login']");
	private final By billingFirstNameFld=By.id("billing_first_name");
	private final By billingLastNameFld=By.id("billing_last_name");
	private final By billingAddress1Fld=By.id("billing_address_1");
	private final By billingCityFld=By.id("billing_city");
	private final By billingStateFld=By.id("billing_state");
	private final By BillingCountryDropDown=By.id("billing_country");
	private final By billingPostCodeFld=By.id("billing_postcode");
	private final By billingEmailFld=By.id("billing_email");
	private final By placeOrderBtn=By.id("place_order");
	private final By messageText=By.cssSelector(".woocommerce-notice");
	private final By directBankTransfer=By.id("payment_method_bacs");
	private final By AlternateCountryDropdown = By.id("select2-billing_country-container");
	private final By AlternateStateDropdown = By.id("select2-billing_state-container");
	private final By productName =By.cssSelector("td[class='product-name']");
	public CheckOutPage selectDirectBankTransfer()
	{
		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(directBankTransfer));
		if(!e1.isSelected()) {
			e1.click();
		 }
		return this;
	}
	
	public CheckOutPage load() throws IOException
	{
		load("/checkout/");
		return this;
	}

	public CheckOutPage loginLbl()
	{
		 wait.until(ExpectedConditions.elementToBeClickable(loginLbl)).click();
		return this;
	}

	public CheckOutPage login(String userName,String password)
	{
		
		
		WebElement e1 = getElement(userNameFld);
		e1.clear();
		e1.sendKeys(userName);
		WebElement e2 = getElement(passwordFld);
		e2.clear();
		e2.sendKeys(password);
		 wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return this;
	}
	public CheckOutPage enterBillingFirstName(String billingFirstName)
	{
		WebElement e = getElement(billingFirstNameFld);
		e.clear();
		e.sendKeys(billingFirstName);
		return this;
	}
	public CheckOutPage enterBillingLastName(String billingLastName)
	{
		WebElement e = getElement(billingLastNameFld);
		e.clear();
		e.sendKeys(billingLastName);
		return this;
	}
	public CheckOutPage enterBillingAddressLine1(String billingAddressLine1)
	{
		WebElement e = getElement(billingAddress1Fld);
		e.clear();
		e.sendKeys(billingAddressLine1);
		return this;
	}
	
	public CheckOutPage enterBillingCity(String billingCity)
	{
		WebElement e = getElement(billingCityFld);
		e.clear();
		e.sendKeys(billingCity);
		return this;
	}

	
	public String getProductName()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
		
	}
	
	
	public CheckOutPage enterBillingPostalCode(String billingPostalCode)
	{
		WebElement e = getElement(billingPostCodeFld);
		e.clear();
		e.sendKeys(billingPostalCode);
		return this;
	}
	public CheckOutPage enterBillingEmail(String billingEmail)
	{
		WebElement e = getElement(billingEmailFld);
		e.clear();
		e.sendKeys(billingEmail);
		return this;
	}
	public CheckOutPage selectBillingState(String billingState) throws InterruptedException
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(AlternateStateDropdown)).click();
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+billingState+"']")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
//		Thread.sleep(2000);
//		
//		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(billingStateFld)));
//		select.selectByVisibleText(billingState);
		
		return this;
	}
	
	public CheckOutPage selectBillingCountry(String billingCountry) throws InterruptedException
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(AlternateCountryDropdown)).click();
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+billingCountry+"']")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		Thread.sleep(2000);
//		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(BillingCountryDropDown)));
//		select.selectByVisibleText(billingCountry);
	return this;
	}

	public CheckOutPage setBillingDetails(BillingDetails billingDetails) throws InterruptedException
	{
		return enterBillingFirstName(billingDetails.getBillingFirstName()).
				enterBillingLastName(billingDetails.getBillingLastName()).
				selectBillingCountry(billingDetails.getBillingCountry()).
				enterBillingAddressLine1(billingDetails.getBillingAddress_Line1()).
				enterBillingCity(billingDetails.getBillingCity()).
				selectBillingState(billingDetails.getBillingState()).
				enterBillingPostalCode(billingDetails.getBillingPostalCode()).
				enterBillingEmail(billingDetails.getBillingEmail());
	}
	
	public CheckOutPage placeOrder()
	{   
		waitForOverLaysToDisappear(showOverLay);
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
		return this;
	}
	public String getNotice()
	{
		return getElement(messageText).getText();
	}
	
}

