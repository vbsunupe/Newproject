package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;



    public class Base {
	public Logger logger;  // for logging
	ReadConfig rc=new ReadConfig(); 

	public WebDriver InitializeBrowser() {

		WebDriver driver = null;
		logger= LogManager.getLogger(this.getClass()); // for logging

		String browserName =rc.getbrowsername();

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			//ChromeOptions ops=new ChromeOptions();
			//ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else if(browserName.equalsIgnoreCase("edge")) {

			//	WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			// EdgeOptions op=new EdgeOptions();
            // op.addArguments("headless");
			//driver = new EdgeDriver(op);
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get(rc.getApplicationURL());
		return driver;

	}

}






