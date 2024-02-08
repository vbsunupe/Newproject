package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage{
	WebDriver driver;
	
	
	By newcustomer=By.xpath("//*[text()=\"New Customer\"]");
	public Homepage(WebDriver driver) {
		this.driver=driver;;
	}
	
	public void clickonnewcustomer() {
		driver.findElement(newcustomer).click();
	}
	
	

}
