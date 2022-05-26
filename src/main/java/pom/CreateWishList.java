package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.CommonMethods;

public class CreateWishList {
	WebDriver driver;
	CommonMethods common = new CommonMethods(DriverManager.getDriver());
	//need consturctor for this class. one to access all the locators with driver
	public CreateWishList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	WebElement Hello;
	
	@CacheLookup
	@FindBy(xpath = "//*[@class='nav-text'][contains(text(),'Create a Wish List')]")
	WebElement wishlist;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"anonCarousel1\"]/ol/li[1]/div/a[2]/span/div")
	WebElement addproduct ;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"] ")
	WebElement signin;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ap_email']")
	WebElement email;
	
	@CacheLookup
	@FindBy(id = "ap_password")
	WebElement pass;
	
	@CacheLookup
	@FindBy(id = "signInSubmit")
	WebElement submit ;
	@CacheLookup
	@FindBy(xpath = "//*[@id='buy-now-button']")
	WebElement buynow;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='nav-item-signout']//*[contains(text(),'Sign Out')]")
	WebElement signout;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[4]")
	WebElement newrelese;
	
	
	
	/*@CacheLookup
	@FindBy
	WebElement*/
	
	public void wishlist() {
		clickelement(wishlist);
}	
	public void signin() {
		clickelement(signin);
	}
	public void sendkeysemail(String emaildata) {
		sendkeys(email, emaildata);
	}
	public void sendkeyspass(String passdata) {
		sendkeys(pass, passdata);
	}
	public void submit() {
		clickelement(submit);
	}
	public void sleproduct() {
		clickelement(addproduct);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void buynow() {
		clickelement(buynow);
	}
	public void signout() {
		clickelement(signout);
	}
	public void newrelese() {
		clickelement(newrelese);
	}
	
	
	
	
	
	
public void clickelement(WebElement ele) {
	//common.higlightement(ele);
	common.waitforElement(ele);
	if (ele.isEnabled()) {
		ele.click();
		//ele.submit();
	}else {
		System.out.println("this is not enabled");
	}
	
}
public void sendkeys(WebElement ele, String Keys ) {
	common.higlightement(ele);
	common.waitforElement(ele);
	
	if (ele.isDisplayed()&& ele.isEnabled()) {
		  ele.sendKeys(Keys);
	}else {
		System.out.println("this in not displayed");
	}
}
}