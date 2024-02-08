package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCheckoutCompletepage{

	WebDriver driver;

	public SaucedemoCheckoutCompletepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//h2")
	WebElement responsemessage;
	
	@FindBy(name="back-to-products")
	WebElement Backhomebtn;
	
	public WebElement responsetext() {

		return responsemessage;
	}
	public WebElement Backhomebtn() {

		return Backhomebtn;
	}
	
	
	
}