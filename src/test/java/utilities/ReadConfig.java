package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File file = new File(".\\src\\test\\resources\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getbrowsername()
	{
		String browser=pro.getProperty("browser");
		return browser;
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String managerpageURL()
	{
		String url=pro.getProperty("managerpageURL");
		return url;
	}
	public String addCustomepageURL()
	{
		String url=pro.getProperty("addcustomerpageurl");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	public String getEdgePath()
	{
	String edgepath=pro.getProperty("edgepath");
	return edgepath;
	}
	
	public String getSaucedemourl()
	{
	String SaucedemoAppurl=pro.getProperty("SaucedemoAppURL");
	return SaucedemoAppurl;
	}
	public String getMagnetourl()
	{
	String MagnetoUrl=pro.getProperty("MagnetoUrl");
	return MagnetoUrl;
	}
	
}




