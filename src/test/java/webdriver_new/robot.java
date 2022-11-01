package webdriver_new;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class robot {
	WebDriver wb;
	public String URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		wb=new ChromeDriver();
		wb.get(URL);
	}
	     @Test
	     public void testcase1() throws AWTException, InterruptedException {
	JavascriptExecutor js= (JavascriptExecutor)wb;
	String title=js.executeScript("return document.title").toString();
	System.out.println(title);
	
	
	String URL=js.executeScript("return document.URL").toString();
	System.out.println(URL);
	
	String domain=js.executeScript("return document.domain").toString();
	System.out.println(domain);
	
	String username=js.executeScript("return document.domain").toString();   
	System.out.println(username);   
	   
	   
	   
	String innertxt=js.executeScript("return document.documentElement.innerText").toString();     
	 System.out.println(innertxt);  // display the innertext or the hidden text
	 
	 
	// String username1=js.executeScript("return document.getElementById('txtUsername').innerText").toString(); 
	 //System.out.println(username);
	 
	 
	 
	 Thread.sleep(3000);
	 js.executeScript("history.go(0)");         // do all things and refresh the page
	 
	 js.executeScript("document.getElementById('txtUsername').value='Admin'");
		Thread.sleep(2000);
		System.out.println("Username Added");
		
		Thread.sleep(3000);
	
		js.executeScript("document.getElementById('txtPassword').value='admin123'");
		System.out.println("Password Added");
		
		js.executeScript("document.getElementById('btnLogin').click();");
		
		js.executeScript("document.getElementById('menu_pim_viewPimModule').click();");
		
		
		//scroll down
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 // scrolling up again
			Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	 Thread.sleep(3000);
	 
	 js.executeScript("document.getElementById('ohrmList_chkSelectRecord_92').scrollIntoView()");
	 
	 
	 
	 
	// String Text = wb.findElement(By.id("content")).getText();
		//System.out.println(Text);
	 
	 
	 //if you wante the hidden table
	 String innertable=js.executeScript("return document.getElementById('resultTable').innerText").toString();    
	  System.out.println(innertable);
			 
			 
			 
			 
			 
			 //Robot rc=new Robot();
	 // rc.keyPress(MenuKeyEvent.VK_DOWN);
	  // Thread.sleep(3000);
	  // rc.mouseWheel(2);
	  // rc.keyPress(MenuKeyEvent.VK_DOWN);
	  // Thread.sleep(3000);
	 //  rc.keyPress(MenuKeyEvent.VK_ENTER);
	 
	   
	     }
}
