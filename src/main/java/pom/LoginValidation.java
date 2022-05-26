package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.CommonMethods;

public class LoginValidation {

	public WebDriver driver;
	CommonMethods common = new CommonMethods(DriverManager.getDriver());
	//need consturctor for this class. one to access all the locators with driver
	public LoginValidation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id='nav-link-accountList'] ")
	WebElement account;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ap_email'] ")
	WebElement email;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@class='a-button-input']")
	WebElement conti;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ap_password']")
	WebElement  pass ;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='signInSubmit'] ")
	WebElement submit;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='nav-item-signout']//*[contains(text(),'Sign Out')] ")
	WebElement signout ;
	
	
	/*
	 * @CacheLookup
	 * 
	 * @FindBy() WebElement ; }
	 */
	public void account() {
		clickelement(account);
	}
	
	public void email(String emaildata) {
		sendkeys(email, emaildata);
	}
	public void contin() {
		clickelement(conti);
	}
	public void pass(String passdata) {
		sendkeys(pass, passdata);
	}
	public void submit() {
		clickelement(submit);
	}
	public void signout() {
		clickelement(signout);
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
