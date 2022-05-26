package test;

import org.testng.annotations.Test;

import pom.LoginValidation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class LoginValidTest extends LaunchTest {
	LoginValidation login;
	@BeforeClass(alwaysRun=true)
	public void beforeclass() {
		
	login = new LoginValidation(driver);
	System.out.println("before class ran"); //i cant delete this line if not need
	}
  @Test(priority = 0)
  public void account() {
	  login.account();
	
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Amazon Sign In"), "This is not expected title"+actualTitle);
			
  }
  @Parameters({"emaildata"})
  @Test(priority = 1)
  public void email(String emaildata) {
	  login.email(emaildata);
	  
  } 
  
  @Test(priority = 2)
  public void conti() {
	  login.contin();
	  
  }
  @Parameters({"passdata"})
  @Test(priority = 3)
  public void pass(String passdata) {
	  login.pass(passdata);
	  
  }
  
  @Test(priority = 4)
  public void submit() {
	  login.submit();
	  try {
		Thread.sleep(400);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals("Amazon.ca: Low Prices – Fast Shipping – Millions of Items"), "This is not expected title"+actualTitle);

  }
  @Test(priority = 5)
  public void hello(){
	  WebElement ele =driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
	  Actions Act =new Actions(driver);
      Act.moveToElement(ele).build().perform(); 
      try {
		Thread.sleep(400);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
  
  }
  
  @Test(priority = 6)
  public void signout() {
	  login.signout();
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Amazon Sign In"), "This is not expected title"+actualTitle);  
  }
  	  
	//invalid test case
  
  @Parameters({"invalidemail"})
	  @Test(priority = 7)
  public void invalidemail(String invalidemail) { 
		  login.email("amazon123@gmail.com");
	 
	 }
  
	  @Test(priority = 8) 
  public void conti1() { 
		  login.contin();
	  
	  }
	  @Parameters({"invalidpass"})
	 @Test(priority = 9) 
	  public void invalidpass( String invalidpass) {
		 login.pass("abcd@123");
	  
	  }
	 
	 @Test(priority = 10) public void submit1() { 
		 login.submit();
		 String actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.contains("Amazon Sign In"), "This is not expected title"+actualTitle);  
	  }
	 
  
  @AfterClass(alwaysRun=true)
  public void afterclass() {
  	
  	login = new LoginValidation(driver);
  	}
  
}
 