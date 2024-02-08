package Saucedemo_testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.Loginpage;
import saucedemo_pageobjects.SaucedemoLoginpage;
import utilities.ReadConfig;
import utilities.XLUtils;

public class Logintest_datadriven extends Base{
	ReadConfig rc=new ReadConfig(); 
	Properties prop=new Properties();
	WebDriver driver;
	@BeforeTest
	public void setup(){
		driver = InitializeBrowser();
		logger.info("browser opened");
		driver.get(rc.getSaucedemourl());
		logger.info("application opened");

	}
	@Test(dataProvider="LoginData")
	public void login_test(String Username,String Password) throws InterruptedException {
		logger.info("**** Test Start ******");
		SaucedemoLoginpage sloginPage = new SaucedemoLoginpage(driver);
		sloginPage.Username().sendKeys(Username);
		logger.info("entered username");
		sloginPage.password().sendKeys(Password);
		logger.info("entered password");
		sloginPage.loginbtn().click();
		logger.info("clicked on click button");
		try {
			sloginPage.logo().isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("**** Test End ******");

	}
	@DataProvider(name="LoginData")
	public String[][] getlogindata() throws IOException {

		//String path=System.getProperty("user.dir")+"//SauceLoginData.xlsx";
		String path="C:\\Users\\visha\\eclipse-workspace\\Guru99bank\\TestData\\SauceLoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Login");
		int colcount=XLUtils.getCellCount(path,"Login", 1);

		String[][] logindata=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Login", i, j);
			}

		}

		return logindata;

	}




}
