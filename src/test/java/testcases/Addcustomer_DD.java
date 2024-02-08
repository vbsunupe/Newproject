package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

import pageobjects.Addcustomerpage;
import pageobjects.Homepage;
import pageobjects.Loginpage;
import utilities.ReadConfig;
import utilities.XLUtils;
import utilities.XLUtils2;

public class Addcustomer_DD extends Base{
	WebDriver driver;
	XLUtils2 excel=new XLUtils2();
	ReadConfig rc=new ReadConfig(); 
	Properties prop=new Properties();

	@BeforeTest
	public void setup(){
		Addcustomerpage ap=new Addcustomerpage(driver);
		driver = InitializeBrowser();
		logger.info("browser opened");
		driver.get(rc.addCustomepageURL());
		logger.info("application opened");

	}
	@Test(dataProvider="data" ,groups="Smoke")
	public void datadriventest(String Customername,String Gender,String DOB,String Address,String City,String state,String pin,String Telephone,String email,String Password) throws InterruptedException {
		Addcustomerpage ap=new Addcustomerpage(driver);
		ap.clickonnewcustomer();
		ap.customername().sendKeys(Customername);
		if(Gender.equalsIgnoreCase("male")) {
			ap.maleradiobtn().click();	}
		else{
			ap.femaleradiobtn().click();
		}

		ap.dob().sendKeys(DOB);
		ap.addressinput().sendKeys(Address);
		ap.cityinput().sendKeys(City);
		ap.stateinput().sendKeys(state);
		ap.pininput().sendKeys(pin);
		ap.mobilenumberinput().sendKeys(Telephone);
		ap.emailinput().sendKeys(email);
		ap.passwordinput().sendKeys(Password);
		ap.submit().click();
	}

	@DataProvider(name="data")
	public String[][] getlogindata() throws IOException {
		//String path=System.getProperty("user.dir")+"//guru99data.xlsx";
		String path="C:\\Users\\visha\\eclipse-workspace\\Guru99bank\\TestData\\guru99data.xlsx";
		int rownum=XLUtils.getRowCount(path, "AddCustomer");
		int colcount=XLUtils.getCellCount(path,"AddCustomer", 1);

		String[][] logindata=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "AddCustomer", i, j);
			}

		}

		return logindata;

	}


}
