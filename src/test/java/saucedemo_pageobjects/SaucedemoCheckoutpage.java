package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCheckoutpage{

	WebDriver driver;

	public SaucedemoCheckoutpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(id="first-name")
	WebElement Firstname;
	
	@FindBy(name="lastName") 
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement  postalcode;
	
	@FindBy(xpath=" //input[@id='continue']")
	WebElement  continuebtn;                            
	

	public WebElement Firstname() {

		return Firstname;
	}
	public WebElement lastname() {

		return lastName;
	}
	public WebElement postalcode() {

		return postalcode;
	}
	public WebElement continuebtn() {

		return continuebtn;
	}
	
	
}