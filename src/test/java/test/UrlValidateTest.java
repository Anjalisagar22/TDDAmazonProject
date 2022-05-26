package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.DriverManager;

public class UrlValidateTest{
	WebDriver driver;
	   DriverManager dm = new DriverManager();
		@BeforeClass(alwaysRun=true)
	public void beforeclass() {
		
	}
  @Test(priority = 0)
  public void url() {
	  dm.setup("Opera", "https://www.Amzon.com/");
	  driver = DriverManager.getDriver();
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Amazon.com. Spend less. Smile more."), "This is not expected title"+actualTitle);
			
	  }


@AfterClass(alwaysRun=true)
public void afterclass() {
	
	dm.teardown();
	}

}