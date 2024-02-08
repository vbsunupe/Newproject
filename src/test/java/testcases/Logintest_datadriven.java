package testcases;

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
		driver.get(rc.getApplicationURL());
		logger.info("application opened");

	}
	@Test(dataProvider="LoginData")
	public void login_test(String Userid,String Password,String status) throws InterruptedException {

		Loginpage loginPage = new Loginpage(driver);
		loginPage.userId().sendKeys(Userid);
		logger.info("entered userid");
		loginPage.password().sendKeys(Password);
		logger.info("entered password");
		loginPage.loginbtn().click();
		logger.info("clicked on click button");
		Alert alert=driver.switchTo().alert();
		alert.accept();
		String errormsg=alert.getText();
		System.out.println(errormsg);
		//assertEquals(errormsg,"");
		logger.info("alert message verified");

	}
	@DataProvider(name="LoginData")
	public String[][] getlogindata() throws IOException {
		String path=System.getProperty("user.dir")+"//guru99loginDATA.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1", 1);

		String[][] logindata=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return logindata;

	}




}
