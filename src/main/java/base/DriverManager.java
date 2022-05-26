package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager {
	
	public static WebDriver driver;
 public void setup(String browser,String url) {
    	
    String path= System.getProperty("user.dir");
    System.out.println("returning the loction my dr>> "+path);
    	
    	 
    	 if (browser.equalsIgnoreCase("opera")) {
    		 
          System.setProperty("webdriver.opera.driver" ,path+"\\Drivers\\operadriver.exe");
           driver=new OperaDriver();
           System.out.println("this is the launched br>>"+ browser);
          
       
		   } else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path+"\\Drivers\\msedgedriver.exe");
		    driver = new EdgeDriver();
		    System.out.println("this is the launched br>>"+ browser);
	
		   }else if (browser.equalsIgnoreCase("chrome")) {
		        
		        System.setProperty("webdriver.chrome.driver",path+ "\\Drivers\\chromedriver.exe");
		        driver = new ChromeDriver();
		        System.out.println("this is the launched br>>"+ browser);
	
		        
		} else {
		        System.out.println("this is not correct choice of browser>>"+ browser);
		    }
		
     if (url!="") {
		driver.get(url);
		System.out.println("the url is >>"+url);
	} else {
driver.get("about:blank");
	System.out.println("the url is blank or not as expacted>>"+url);
	}
	
     
     driver.manage().window().maximize(); 
     
 
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);}
     
   
      public void teardown() {
    	 driver.quit();
    	// driver.close();
     }
       
 public static  WebDriver getDriver() {
return driver;

	 
	 
	 
 }
}
