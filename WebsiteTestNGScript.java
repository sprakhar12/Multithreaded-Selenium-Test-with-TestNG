/* Prakhar Saxena */

package seleniumtestpackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebsiteTestNGScript {

	//static long start = 0;
	
	//Implementing thread object to implement Runnable interface
	Linkthread lt = new Linkthread();
			
	//Passing the Implementing thread object reference to main thread
	Thread main = new Thread(lt);
		
	@BeforeTest
	public void setup() throws Exception
	{
		
		//calling setup method from Util class
		Util.init();
	
		/*
		 * waiting in case results are not completely stored into
		 * WebElement arrays created in Util class and avoiding calling null array 
		*/
		Util.driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	}
		
	@Test
	public void testWebsiteLinksHoverAndClick()
	{
		//main or parent thread starts
		main.start();
		
		/*start time of the main thread
		start = System.nanoTime();*/
		
		try {
			//Wait for the completion of all tasks before thread dies
			main.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	@AfterTest
	public void shutDown() throws InterruptedException
	{
		//Delaying the closing of a browser
		Thread.sleep(10000);
		Util.tearDown();
	}
}
