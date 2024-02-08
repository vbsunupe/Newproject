package Magneto_testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Magneto_pageobjects.Accountpage;
import Magneto_pageobjects.CustomerAccountpage;
import Magneto_pageobjects.MagnetoHomepage;
import base.Base;
import utilities.ReadConfig;

public class Accountpagetest extends Base {
		ReadConfig rc=new ReadConfig(); 
		Properties prop=new Properties();
		WebDriver driver;
		@BeforeTest
		public void setup(){
			driver = InitializeBrowser();
			logger.info("browser opened");
			driver.get(rc.getMagnetourl());
			logger.info("application opened");
		}
		@Test(priority=1)
		public void verifytitle() {
			logger.info("**** Test 1 Start ******");
			MagnetoHomepage magnetoPage = new MagnetoHomepage(driver);
			Accountpage accountpge=new Accountpage(driver);
			magnetoPage.CreateAnaccount().click();
			logger.info("**** account page opened ******");
			String title=driver.getTitle();
			try {
			assertEquals(title,"Create New Customer Account");
			logger.info("**** Test pass ******");
			}catch(Exception e) {
				e.printStackTrace();	
			}
			logger.info("**** Test End ******");	
		}
		@Test(priority=2)
		public void verifylogo() {
			logger.info("**** Test2 Start ******");
			MagnetoHomepage magnetoPage = new MagnetoHomepage(driver);
			Accountpage accountpge=new Accountpage(driver);
			magnetoPage.CreateAnaccount().click();
			logger.info("**** account page opened ******");
			try {
			assertEquals(accountpge.logo().isDisplayed(), true);
			}catch(Exception e) {
				e.printStackTrace();
			}
			logger.info("**** Test End ******");	
		}
		@Test(priority=3)
		public void verifyerrormsg() {
			logger.info("**** Test3 Start ******");
			MagnetoHomepage magnetoPage = new MagnetoHomepage(driver);
			Accountpage accountpge=new Accountpage(driver);
			magnetoPage.CreateAnaccount().click();
			logger.info("**** account page opened ******");
			accountpge.firstname().sendKeys("vcbs"); 
			accountpge.firstname().sendKeys(Keys.ENTER);
			String errormsg=accountpge.errormsg().getText();
			String Aerrormsg="This is a required field.";
		
		    assertTrue(errormsg.contains(Aerrormsg));
			logger.info("**** errormsg verified ******");
			logger.info("**** Test3 end ******");
        }
		@Test(priority=4)
		public void verifybrokenlinks() {
			logger.info("**** Test4 Start ******");
			MagnetoHomepage magnetoPage = new MagnetoHomepage(driver);
			Accountpage accountpge=new Accountpage(driver);
			magnetoPage.CreateAnaccount().click();
			logger.info("**** account page opened ******");
			List<WebElement> links = driver.findElements(By.xpath("/a"));

			// Iterating each link and checking the response status
			for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
			}

			logger.info("**** Test4 end ******");
			
			}


			public static void verifyLink(String url) {
			try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			}
			else {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			}
			catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
			}
			}
			
		
		@AfterTest
		public void closure(){
			driver.close();
			logger.info("browser closed");
		}

}