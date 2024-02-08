package Magneto_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountpage{

	WebDriver driver;

	public CustomerAccountpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath="//div[@class=\"page messages\"]")
	WebElement confirmationmessage;
	

	public WebElement confirmationmessage() {

		return confirmationmessage;
	}
	
	
	
}
