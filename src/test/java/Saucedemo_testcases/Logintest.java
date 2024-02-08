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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Base;
import pageobjects.Loginpage;
import saucedemo_pageobjects.SaucedemoLoginpage;
import utilities.ReadConfig;

public class Logintest extends Base{
	ReadConfig rc=new ReadConfig(); 
	Properties prop=new Properties();
	ExtentReports extent=new ExtentReports();
	ExtentTest test;
	WebDriver driver;
	@BeforeTest
	public void setup(){
		ExtentSparkReporter htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/AReports/extentReport.html");
	
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setTheme(Theme.STANDARD);

	    //helps to generate the logs in the test report.
	    
        extent.attachReporter(htmlReporter);
        
        
        
		driver = InitializeBrowser();
		logger.info("browser opened");
		driver.get(rc.getSaucedemourl());
		logger.info("application opened");
	}
	@Test()
	public void logintest() {
	    test = extent.createTest("Test Case 1_login");
		logger.info("**** Test Start ******");
		SaucedemoLoginpage sloginPage = new SaucedemoLoginpage(driver);
		sloginPage.Username().sendKeys("standard_user");
		logger.info("entered username");
		sloginPage.password().sendKeys("secret_sauce");
		logger.info("entered password");
		sloginPage.loginbtn().click();
		logger.info("clicked on click button");
		
		if (sloginPage.logo().isDisplayed()==true) {
			test.log(Status.PASS, "test is passed");
			System.out.println("test is passed");
		}
		else {
			test.log(Status.FAIL, "test is fail");
			System.out.println("test is failed");
		}
		
		logger.info("**** Test End ******");
	}
	
	@AfterTest
	public void closure(){
		driver.close();       
		logger.info("browser closed");   
	}
}



