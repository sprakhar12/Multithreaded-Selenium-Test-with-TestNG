package seleniumtestpackage;

/*import java.text.DecimalFormat;
import java.text.NumberFormat;*/

import org.openqa.selenium.interactions.Action;

//this is one way to implement thread execution, other is extends Thread
public class Linkthread implements Runnable {
	
	// Sequence to be tested on the links: hover then click
	
	/*
	 * run is the main or entry method which is invoked by JVM
	 * when a thread is started via its start() method
	 *
	*/
	public void run(){
		
		Thread _hovers = new Thread(new Runnable(){
			
			public void run(){
				for(int i=0; i<Util.getHovers().length; i++){
					//synchronized block to compete for the associated lock of monitor object
					//only one thread instruction will execute at at time
					//guarantees serializable execution
					synchronized (MonitorUtil.Lock){
						//Action class that is needed when executing mouse events
						/*
						 * moveToElement is a method of Actions class which
						 * moves the mouse to the middle of the element.
						 * build() method compiles the listed action
						 * perform() method executes the Action object
						*/
						Action mouseOver = Util.builder.moveToElement(Util.getHovers()[i]).build();
						mouseOver.perform();
						
						//getText() method will give the text, bounded with the WebElement of the web page
						System.out.println("hover on " +Util.getHovers()[i].getText()+ " successful");
						
						/*
						 * current thread will get notified on the same monitor object
						 * to acquire the released lock
						*/
						MonitorUtil.Lock.notify();
						try {
							/*
							 * current thread will wait for the other thread on the same monitor object
							 * until notified or other thread releases the lock
							*/
							MonitorUtil.Lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		Thread _links = new Thread(new Runnable(){
				
			public void run(){
				for(int i=0; i<Util.getLinks().length; i++){
					//synchronized block to compete for the associated lock of monitor object
					//only one thread instruction will execute at at time
					//guarantees serializable execution
					synchronized (MonitorUtil.Lock)
					{
					//click() method will click on the intended WebElement after finding it inside the web page
					Util.getLinks()[i].click();
					
					/*getText() method will give the text, bounded with the intended WebElement 
					 *after finding it inside the web page
					*/
					System.out.println("Click on " +Util.getLinks()[i].getText()+ " successful");
					
					/*
					 * current thread will get notified on the same monitor object
					 * to acquire the released lock
					*/
					MonitorUtil.Lock.notify();
					try {
						/*
						 * current thread will wait for the other thread on the same object monitor 
						 * until notified or other thread releases the lock
						*/
						MonitorUtil.Lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		_hovers.start();
		_links.start();
		
		/*total time calculated when all the tasks are completed by all the child threads and
		the main thread dies by calling join() 
		long total = System.nanoTime() - WebsiteTest.start;
		NumberFormat formatter = new DecimalFormat("#0.0000");
		System.out.println("Overall Testing time" + "\t : " + formatter.format(total / 1000000000d) + " seconds");
		System.out.println("--------------------------");*/
	}
	
	// Monitor class
	static class MonitorUtil
	{
		//Monitor object to acquire and release lock
		final static Object Lock = new Object();
	}

}