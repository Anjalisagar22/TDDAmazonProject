package test;

import org.testng.annotations.Test;


import pom.CreateWishList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class WishListTest extends LaunchTest {
CreateWishList create;
@BeforeClass(alwaysRun=true)
public void beforeclass() {
	
create = new CreateWishList(driver);
System.out.println("before class ran"); 
}
  @Test(priority = 0)
  public void helloaccout() {
	 
	  WebElement ele =driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
	  Actions Act =new Actions(driver);
      Act.moveToElement(ele).build().perform(); 
  }
  @Test(priority = 1)
  public void wishlist() {
	  create.wishlist();
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals("Wish List"), "This is not expected title"+actualTitle);
}
  
  @Test(priority = 2)
  public void signin() {
	  create.signin();
  }
  @Parameters({"emaildata"})
  @Test(priority = 3)
  public void email(String emaildata) {
	  create.sendkeysemail(emaildata);
	  
  }
  @Parameters({"passdata"})
  @Test(priority = 4)
  public void pass(String passdata) {
	  create.sendkeyspass(passdata);
	  
  }
  @Test(priority = 5)
  public void submit() {
	  create.submit();
	  
  }
  @Test(priority = 6)
  public void sleproduct() {
	  create.sleproduct();
	}
	  
  @Test(priority = 7)
  public void buynow() {
	  create.buynow();
	 
	  String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals("Select a Payment Method - Amazon.com Checkout"), "This is not expected title"+actualTitle);
  driver.navigate().to("https://www.Amazon.ca/");
 
  WebElement ele =driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
  Actions Act =new Actions(driver);
  Act.moveToElement(ele).build().perform();
  create.signout();
  driver.navigate().back();
  }
  @Test(priority = 8)
  public void newrele() {
	  create.newrelese();
	  try {
		Thread.sleep(600);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	  String actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.equals("Amazon.ca Hot New Releases: The bestselling new & future releases on Amazon"), "This is not expected title"+actualTitle);
  //new relese is changing very often so title might give an error
  }
  
  
  @AfterClass(alwaysRun=true)
  public void afterclass() {
  	
	  create = new CreateWishList(driver);
  	}
  

}
