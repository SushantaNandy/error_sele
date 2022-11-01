package webdriver_new;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class playing_with_actions {
	WebDriver wb;
	public String URL="https://www.google.com";
	public String URL1="https://demoqa.com/browser-windows";
	public String URL2="https://www.youtube.com/";
	public String URL3="https://www.browserstack.com/guide/mouse-hover-in-selenium";
	

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		wb=new ChromeDriver();
		wb.get(URL3);
	}
	     @Test(enabled=false)
	     public void testcase1() throws AWTException, InterruptedException {
	    	WebElement link= wb.findElement(By.xpath("//*[contains(text(),'Gmail')]"));
	    	
	    	Actions act=new Actions(wb);               // action class
	    	
	    	
	    	act.contextClick(link).build().perform();  //Right Click operation usuallay done using action class
	    	
	    	Robot rc= new Robot();        // usually used to do the browser control
	    	
	    	rc.keyPress(MenuKeyEvent.VK_DOWN);       // mouse actions
	    	rc.keyPress(MenuKeyEvent.VK_ENTER);
	    	Thread.sleep(3000);
	    	rc.keyPress(MenuKeyEvent.VK_CONTROL);     // to perform the keybord action for switching tabs
			rc.keyPress(MenuKeyEvent.VK_TAB);
			
			
Set<String> tabs=wb.getWindowHandles();         // used to get get the both child and parent tabs id which are opean
System.out.println(tabs);

String parenttab=wb.getWindowHandle();                // use to get the current tabs which is opean it's unique id
System.out.println(parenttab);

//for enhanced loop
for(String handles: tabs) {
	wb.switchTo().window(handles);       // for switching to that particular tab which was during itteration of that loop
	//wb.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");  // if i want to change all the tabs to oarnge hrm 
	System.out.println(wb.getTitle());      // and print the tile for that particual tab
	
}

wb.switchTo().window(parenttab);    // if i want 2 go to the parent tab and close it i will use wb.close();
wb.close(); 

wb.quit();                       // close all the running tabs 

}
	     
	     @Test(enabled=false)
	     public void testcase2() throws InterruptedException {
	    	 for(int i=0;i<3;i++) {
	    		 wb.findElement(By.xpath("//*[@id='windowButton']")).click();
	    	 }
	    	 String parentwindow=wb.getWindowHandle();
	    	 System.out.println(parentwindow);
	    	 
	    	 Set<String> childwindows=wb.getWindowHandles();
	    	 System.out.println(childwindows);
	    	 
	    	 for(String a: childwindows) {
	    		// wb.switchTo().window(a);
	    	  wb.get(URL2);
	    		 System.out.println(wb.getTitle());
	    	 }
	      wb.navigate().refresh();       // this is done to refresh a page
	      Thread.sleep(2000);
	    	wb.close();
	    	
	    	wb.quit();
	    	
	     }
	     @Test(invocationCount = 3)
	     public void testcase3() throws InterruptedException, AWTException{
	    WebElement	link= wb.findElement(By.xpath("//*[@class='nav_item_name']"));
	    Actions action = new Actions(wb);

	  //Performing the mouse hover action on the target element.
	  action.moveToElement(link).build().perform();
	  Thread.sleep(3000);
	 // action.sendKeys(Keys.ARROW_DOWN).build().perform();   // it is for page down
	// WebElement link1= wb.findElement(By.xpath("//*[@title='Support']"));
	  WebElement	link1= wb.findElement(By.xpath("//*[contains(text(),'Status')]"));
	action.click(link1).build().perform();
	wb.close();

	     }
			}
