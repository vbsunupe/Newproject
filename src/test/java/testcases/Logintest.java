package testcases;

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
import utilities.ReadConfig;

public class Logintest extends Base{
	ReadConfig rc=new ReadConfig(); 
	Properties prop=new Properties();

	WebDriver driver;

	@BeforeTest
	public void setup(){
		driver = InitializeBrowser();
		logger.info("browser opened");
		driver.get(rc.getApplicationURL());
		logger.info("application opened");

	}
	@Test(groups= {"regression"})
	public void logintest() {
		Loginpage loginPage = new Loginpage(driver);
		loginPage.userId().sendKeys(rc.getUsername());
		logger.info("entered userid");
		loginPage.password().sendKeys(rc.getPassword());
		logger.info("entered password");
		loginPage.loginbtn().click();
		logger.info("clicked on click button");
		String pagetitle=driver.getTitle();
		assertEquals(pagetitle,"Guru99 Bank Manager HomePage");
		logger.info("title verified");
	}
	//@Test(groups= {"sanity"})
	public void logoverification() {
		Loginpage loginPage = new Loginpage(driver);

		assertTrue(loginPage.logo().isDisplayed());
		logger.info("logo verification done");
	}
	@AfterTest
	public void closure(){
		driver.close();
		logger.info("browser closed");


	}


}



