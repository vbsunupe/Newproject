package saucedemo_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLoginpage{

	WebDriver driver;

	public SaucedemoLoginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(id="user-name")
	WebElement Username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement loginbtn;
	@FindBy(xpath="//div[@class=\"app_logo\"]")
	WebElement logo;

	public WebElement Username() {

		return Username;
	}
	public WebElement password() {

		return password;
	}
	public WebElement loginbtn() {

		return loginbtn;
	}
	public WebElement logo() {

		return logo;
	}
	
}
