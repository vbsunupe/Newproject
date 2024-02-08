package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCartpage{

	WebDriver driver;

	public SaucedemoCartpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//button[@id='checkout']")
	WebElement CheckoutbtnBtn;
	@FindBy(id="item_2_title_link")
	WebElement itemtitle;
	@FindBy(id="remove-sauce-labs-onesie")
	WebElement removebtn;

	public WebElement CheckoutbtnBtn() {

		return CheckoutbtnBtn;
	}
	public WebElement Itemtitle() {

		return itemtitle;
	}
	public WebElement removebtn() {

		return removebtn;
	}
	
	
}