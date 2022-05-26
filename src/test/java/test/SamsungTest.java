package test;

import org.testng.annotations.Test;

import pom.SamsungMobile;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class SamsungTest extends LaunchTest {
	SamsungMobile select;
	
	@BeforeClass(alwaysRun=true)
	public void beforeclass() {
		
		select = new SamsungMobile(driver);
	System.out.println("before class ran"); 
	}
  @Test(priority = 0)
  public void search () {
	  select.search();
try {
	Thread.sleep(500);
} catch (InterruptedException e) {

	e.printStackTrace();
}
		
}
	
  
  @Test(priority = 1)
  public void clickserch() {
	  select.submittext();
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
  }
  
  @Test(priority = 2)
  public void result() {
	  select.validresult();
	  try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();

			String actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.equals("Amazon.ca : \"samsung galaxy s10\""), "This is not expected title"+actualTitle);
  }	
  }
  @Test(priority = 3)
  public void slephone() {
	  select.slephone();
  }
 
  @Test(priority = 4)
  public void price() {
	  select.price();
  }
  @Test(priority = 5)
  public void location() {
	  select.location();
  }
  @Parameters({"zip1"})
  @Test(priority = 6)
  public void zip1(String zip1) {
	  select.zip1(zip1);
  }
  @Parameters({"zip2"})
  @Test(priority = 7)
  public void zip2(String zip2) {
	  select.zip2(zip2);
  }
  @Test(priority = 8)
  public void apply() {
	  select.apply();
  }
  @Test(priority = 9)
  public void newloction() {
	  select.newloca();
  }//this loction path is changing often
  
  @Test(priority = 10)
  public void cart() {
	  select.cart();
  }
  
  @Test(priority = 11)
  public void addcart() {
	  select.addcart();
  }
  
  @Test(priority = 12)
  public void checkout() {
	  select.checkout();
	  driver.navigate().back();
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals("Amazon Sign In"), "This is not expected title"+actualTitle);
  }
  
 
  
@AfterClass(alwaysRun=true)
public void afterclass() {
	
	select= new SamsungMobile(driver);
	}

}