package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCheckoutTwopage{

	WebDriver driver;

	public SaucedemoCheckoutTwopage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(id="finish")
	WebElement finishbtn;
	
	public WebElement finish() {

		return finishbtn;
	}
	
	
	
}