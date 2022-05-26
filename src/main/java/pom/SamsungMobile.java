package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.CommonMethods;

public class SamsungMobile {

	public WebDriver driver;
	CommonMethods common = new CommonMethods(DriverManager.getDriver());
	
	public SamsungMobile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	WebElement search;

@CacheLookup
@FindBy(id = "nav-search-submit-button")
WebElement submittext;


@CacheLookup
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div[2]/div[1]/h2/a/span")
	WebElement slephone;
	

	@CacheLookup
	@FindBy(xpath = "//*[contains(text(),'1-48 of over 4,000 results for')]")
	WebElement results;//Your Lists
	

	@CacheLookup
	@FindBy(xpath = "//*[@id='volumeAwarePricingTableLoader_feature_div']")
	WebElement price;
	

	@CacheLookup
	@FindBy(xpath = "//*[@id='cipInsideDeliveryBlock_feature_div']")
	WebElement location;
	

	@CacheLookup
	@FindBy(id="GLUXZipUpdateInput_0")
	WebElement zipCode1;
	
	@CacheLookup
	@FindBy(id="GLUXZipUpdateInput_1")
	WebElement zipCode2;
	
	@CacheLookup
	@FindBy(xpath="//*[@id='GLUXZipUpdate']/span/input")
	WebElement Apply;
	

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"contextualIngressPt\"]")
	WebElement newlocation;
	

	@CacheLookup
	@FindBy(xpath = "//*[@id='add-to-cart-button']")
	WebElement cart;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"sw-atc-details-single-container\"]/div[2]")
	WebElement addedtocartmass;//Amazon.ca Shopping Cart

	@CacheLookup
	@FindBy(id = "sw-ptc-form")
	WebElement checkout;
	
	

	public void search() {
		sendkeys(search, "samsung galaxy s10");
	}
		public void submittext() {
			clickelement(submittext);
		}
		public void slephone() {
			clickelement(slephone);
		}
	public void validresult() {
		clickelement(results);//1-48 of over 4,000 results for
	}
	
	public void price() {
clickelement(price);
	}
	public void location() {
		clickelement(location);
	}
	public void zip1(String zip1) {
		sendkeys(zipCode1, zip1);
	}
	public void zip2(String zip2) {
		sendkeys(zipCode2, zip2);
	}
	public void apply() {
		clickelement(Apply);
	}
	public void newloca() {
		
		clickelement(newlocation);
	}
	public void cart() {
		clickelement(cart);
	}
	public void addcart() {
		clickelement(addedtocartmass);
		}
	public void checkout() {
		clickelement(checkout);
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
	
	

	/*@CacheLookup
	@FindBy
	WebElement*/