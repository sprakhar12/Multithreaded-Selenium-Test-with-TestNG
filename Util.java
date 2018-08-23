package seleniumtestpackage;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	/* You can change the Path of Chrome based on your environment here */
	public static final String loc = "C:\\chromedriver_win32\\chromedriver.exe";
	
	public static final String url = "http://www.demo.guru99.com/test/yahoo.html";

	// Time to wait when searching for a GUI element 
	public static final int WAIT_TIME = 20; 
		
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	//Actions class that is needed when executing mouse events
	public static Actions builder;
	
	public static WebElement[] all_links = new WebElement[7];
	public static WebElement[] all_hovers = new WebElement[7];
	
	//Setup step
	 public static void init() throws Exception{
	    	System.setProperty("webdriver.chrome.driver",loc);
	    	driver = new ChromeDriver();
	    	driver.manage().timeouts()
			.implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	    	driver.get(url);
	    	builder = new Actions(driver);
	    }
	 
	 
	 // Though all_links and all_hovers have same size and
	 // both of them belongs to property of same group of links
	 // so we could run only one method out of two methods mention below getHovers() and getLinks()
	 // but to follow separation of concern, generalization is done
	 
	 /*
	  * Getting all hover on link Web Elements corresponding to specific id
	  * and storing it in all_links array of type WebElement
	  * See ByXPath inside the method 
	 */
	 public static WebElement[] getHovers(){
		 int i =0;
		 while(i<all_hovers.length){
			 //all_hovers[i]=(driver.findElement(ByXPath.xpath("//*[@id='navbar-collapse']/ul/li["+Integer.toString(i+1)+"]/a")));
			 all_hovers[i] = driver.findElement(By.id("pager"+String.valueOf(i+1)));
			 i++;
		 }
		 return all_hovers;
	 }
	 
	 /*
	  * Getting all link Web Elements corresponding to specific id
	  * and storing it in all_hovers array of type WebElement
	  * See ByXPath inside the method 
	  * */
	 public static WebElement[] getLinks(){
		 int i =0;
		 while(i<all_links.length){
			 //all_links[i]=(driver.findElement(ByXPath.xpath("//*[@id='navbar-collapse']/ul/li["+Integer.toString(i+1)+"]/a")));
			 all_links[i] = driver.findElement(By.id("pager"+String.valueOf(i+1)));
			 i++;
		 }
		 return all_links;
	 }
	 
	 // closing the driver connection and looping out of the automation control on the browser
	 public static void tearDown(){
		 driver.close();
	 }

}
