package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoInventorypage{

	WebDriver driver;

	public SaucedemoInventorypage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(name="add-to-cart-sauce-labs-bike-light")
	WebElement AddtocartBtn;
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	WebElement cart;
	@FindBy(xpath="//select")
	WebElement dropdown;
	@FindBy(name="add-to-cart-sauce-labs-onesie")
	WebElement onesieAddtoCart;                                         

	public WebElement AddtocartBtn() {

		return AddtocartBtn;
	}
	public WebElement cart() {

		return cart;
	}
	public WebElement dropdown() {

		return dropdown;
	}
	public WebElement onesieAddtoCart() {

		return onesieAddtoCart;
	}
	
	
}
