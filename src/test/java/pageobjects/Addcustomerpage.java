package pageobjects;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomerpage{
	WebDriver driver;
	
	

   // @FindBy(xpath="//ul[@class=\"menusubnav\"]/li[2]")  
     //WebElement newcustomer;
    By newcustomer=By.xpath("//a[text()=\"New Customer\"]");
 
    
    @FindBy(xpath="//input[@name='name']")  
     WebElement customername;
    @FindBy(name="rad1")
    WebElement maleradiobtn;
    @FindBy(xpath="//input[@value=\\\"f\\\"]")
    WebElement femaleradiobtn;
    @FindBy(id="dob")
    WebElement dob;
    @FindBy(name="addr")
    WebElement addressinput;
    @FindBy(name="city")
    WebElement cityinput;
    @FindBy(name="state")
    WebElement stateinput;
    @FindBy(name="pinno")
    WebElement pininput;
    @FindBy(name="telephoneno")
    WebElement mobilenumberinput;
    @FindBy(name="emailid")
    WebElement emailinput;
    @FindBy(name="password")
    WebElement passwordinput;
    @FindBy(name="sub")
    WebElement submit;
    
	public Addcustomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickonnewcustomer() {
		driver.findElement(newcustomer).click();
	}
	public WebElement customername() {
		return customername;
	}
	
	public WebElement maleradiobtn() {
		return maleradiobtn;
	}
	public WebElement femaleradiobtn() {
		return femaleradiobtn;
	}
	public WebElement dob() {
		return dob;
	}
	public WebElement addressinput() {
		return addressinput;
	}
	public WebElement cityinput() {
		return cityinput;
	}
	public WebElement stateinput() {
		return stateinput;
	}
	public WebElement pininput() {
		return pininput;
	}
	public WebElement mobilenumberinput() {
		return mobilenumberinput;
	}
	public WebElement emailinput() {
		return emailinput;
	}
	public WebElement passwordinput() {
		return passwordinput;
	}
	public WebElement submit() {
		return submit;
	}
}
