package Magneto_testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Magneto_pageobjects.Accountpage;
import Magneto_pageobjects.CustomerAccountpage;
import Magneto_pageobjects.MagnetoHomepage;
import base.Base;
import pageobjects.Loginpage;
import saucedemo_pageobjects.SaucedemoLoginpage;
import utilities.ReadConfig;
import utilities.XLUtils;

public class Createan_account extends Base{
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
	@Test(dataProvider="Data")
	public void createaccountntest(String firstname,String lastname,String email,String password,String passwordconfirm) {
	
		logger.info("**** Test Start ******");
		MagnetoHomepage magnetoPage = new MagnetoHomepage(driver);
		Accountpage accountpge=new Accountpage(driver);
		CustomerAccountpage cpage=new CustomerAccountpage(driver);
		magnetoPage.CreateAnaccount().click();
		if (accountpge.logo().isDisplayed()==true) {
			logger.info("**** logo displayed ******");
		}
		else {
			logger.info("**** logo is not  displayed ******");

		}
		accountpge.firstname().sendKeys(firstname);
		accountpge.lastname().sendKeys(lastname);
		accountpge.email().sendKeys(email);
		accountpge.password().sendKeys(password);
		accountpge.passwordconfirm().sendKeys(passwordconfirm);
		logger.info("all information filled");
		accountpge.createaccbtn().click();
		logger.info("clicked on create account button");
		if (cpage.confirmationmessage().isDisplayed()==true) {
			logger.info("**** msg diaplayed******");
		}
		else {
			logger.info("**** msg  not diaplayed******");

		}

        System.out.println(System.getProperty("user.dir"));
		logger.info("**** Test End ******");
	}
	@DataProvider(name="Data")
	public String[][] getlogindata() throws IOException {

		//String path=System.getProperty("user.dir")+"TestData//Data.xlsx";
		String path="C:\\Users\\visha\\eclipse-workspace\\AutomationProject\\TestData\\Data.xlsx";
		int rownum=XLUtils.getRowCount(path, "data");
		int colcount=XLUtils.getCellCount(path,"data", 1);

		String[][] data=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j]=XLUtils.getCellData(path, "data", i, j);
			}

		}

		return data;

	}

	@AfterTest
	public void closure(){
		driver.close();
		logger.info("browser closed");
	}
}



