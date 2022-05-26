package test;


import base.DriverManager;
import utils.ReadProperties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class LaunchTest {
	 static WebDriver driver;
	   DriverManager dm = new DriverManager();
	   ReadProperties readprops;
	   String filename="C:\\Automation\\Selenium-Anju\\TDDAmazonProject\\config,properties";
	   
	   
@Parameters({"browser","url"})
 @BeforeSuite(alwaysRun=true)
 public void beforeSuite(String browser, String url) {

 dm.setup(browser, url);
 driver = DriverManager.getDriver();
 }

 @AfterSuite
 public void afterSuite() {
	  
	  
	  dm.teardown();
	
 }

}
