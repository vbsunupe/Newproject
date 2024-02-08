package Magneto_pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage{

	WebDriver driver;

	public Accountpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath="//a[@class=\"logo\"]")
	WebElement logo;
	@FindBy(id="firstname")
	WebElement firstname;
	@FindBy(id="lastname")
	WebElement lastname;
	@FindBy(id="email_address")
	WebElement email;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="password-confirmation")
	WebElement 	passwordconfirm;
	@FindBy(xpath="//button[@title=\"Create an Account\"]")
	WebElement 	createaccbtn;
	@FindBy(xpath="//div[normalize-space(text())='This is a required field.']")
	WebElement errormsg;
	
	

	
	public WebElement logo() {

		return logo;
	}
	public WebElement firstname() {

		return firstname;
	}
	public WebElement lastname() {

		return lastname;
	}
	public WebElement email() {

		return email;
	}
	public WebElement password() {

		return password;
	}
	public WebElement passwordconfirm() {

		return passwordconfirm;
	}
	public WebElement createaccbtn() {

		return createaccbtn;
	}
	public WebElement errormsg() {

		return errormsg;
	}
	
	
}
