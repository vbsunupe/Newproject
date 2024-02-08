package Saucedemo_testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.Loginpage;
import saucedemo_pageobjects.SaucedemoCartpage;
import saucedemo_pageobjects.SaucedemoCheckoutCompletepage;
import saucedemo_pageobjects.SaucedemoCheckoutTwopage;
import saucedemo_pageobjects.SaucedemoCheckoutpage;
import saucedemo_pageobjects.SaucedemoInventorypage;
import saucedemo_pageobjects.SaucedemoLoginpage;
import utilities.ReadConfig;

public class ProductPurchasetest extends Base{
	WebDriver driver;
	ReadConfig rc=new ReadConfig(); 
	Properties prop=new Properties();
	


	@BeforeTest
	public void setup(){
		driver = InitializeBrowser();
		logger.info("browser opened");
		driver.get(rc.getSaucedemourl());
		logger.info("application opened");

	}
	@Test()
	public void ProductPurchasetest() {
		SaucedemoLoginpage sloginPage = new SaucedemoLoginpage(driver);
		SaucedemoInventorypage ip=new SaucedemoInventorypage(driver);
		SaucedemoCartpage cp=new SaucedemoCartpage(driver);
		SaucedemoCheckoutpage checkoutpage=new SaucedemoCheckoutpage(driver);
		SaucedemoCheckoutTwopage checkoutpage2 = new SaucedemoCheckoutTwopage(driver);
		SaucedemoCheckoutCompletepage ccpage=new SaucedemoCheckoutCompletepage(driver);
		logger.info("**** Product Purchasetest Test Start ******");
		sloginPage.Username().sendKeys("standard_user");
		logger.info("entered username");
		sloginPage.password().sendKeys("secret_sauce");
		logger.info("entered password");
		sloginPage.loginbtn().click();
		logger.info("clicked on click button");
		ip.AddtocartBtn().click();
		logger.info("**** clicked on add to cart btn******");
		ip.cart().click();
		logger.info("**** clicked on cart icon******");
		cp.CheckoutbtnBtn().click();
		logger.info("**** clicked on checkout btn******");
		checkoutpage.Firstname().sendKeys("vishal");
		checkoutpage.lastname().sendKeys("sunupe");
		checkoutpage.postalcode().sendKeys("413529");
		logger.info("**** Information filled******");
		checkoutpage.continuebtn().click();
		logger.info("**** clicked on continue btn******");
		checkoutpage2.finish().click();
		logger.info("**** clicked on finish btn******");
		String confirmmsg=ccpage.responsetext().getText();
		System.out.println(confirmmsg);
		confirmmsg.contains("Thank you for your order!");
		logger.info("**** Confirm message verified ******");
		logger.info("**** Test End ******");
	}
	
	@AfterTest
	public void closure(){
		driver.close();
		logger.info("browser closed");


	}


}



