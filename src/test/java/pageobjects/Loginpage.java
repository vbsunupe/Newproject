package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage{

	WebDriver driver;

	public Loginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//input[@name='uid']")
	WebElement userId;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement newcustomer;
	@FindBy(xpath="//a[@style=\"border: medium none;\" ]")
	WebElement logo;
	

	public WebElement userId() {

		return userId;
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
