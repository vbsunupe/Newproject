package Magneto_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetoHomepage{

	WebDriver driver;

	public MagnetoHomepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement CreateAnaccount;
	

	public WebElement CreateAnaccount() {

		return CreateAnaccount;
	}
	
	
}
