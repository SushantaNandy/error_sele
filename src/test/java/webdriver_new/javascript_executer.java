package webdriver_new;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascript_executer {

	WebDriver wb;
	public String URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	public String URL1="https://demoapp.skillrary.com";
	public String URL2="https://demoqa.com/webtables";
	public String URL3="https://demoqa.com/upload-download";
	public String URL4="https://demoqa.com/frames";
	public String URL5="https://demoqa.com/droppable";

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		wb=new ChromeDriver();
		wb.get(URL5);
		
		
	}
	
	@Test(enabled=false)
	public void testcase1() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)wb;
	System.out.println(js.executeScript("return document.title"));    // it is used to return the title of the url u opean
	
	System.out.println(js.executeScript("return document.domain"));   // it is used to get the domain
	
    System.out.println(js.executeScript("return document.documentElement.innerText"));	// for fetching all the innertext
    
    System.out.println(js.executeScript("return document.getElementById('divUsername').innerText"));  // for fetching the inner text of username block
    
    Thread.sleep(3000);
    js.executeScript("history.go(0)");
    
    js.executeScript("window.history.forward(0)");   // to go forward 
    
    js.executeScript("window.history.back(0)");     // to go backward
    
    
	}
	
	@Test(enabled=false)
	public void testcase3() throws InterruptedException {
		wb.findElement(By.xpath("//*[@href='login.php?type=login']")).click(); // login via javascript
		
		wb.findElement(By.xpath("//*[@id='email']")).sendKeys("user");
		
		wb.findElement(By.xpath("//*[@id='password']")).sendKeys("user");
		
		wb.findElement(By.xpath("//*[@id='last']")).click();
		
		Thread.sleep(3000);
		wb.findElement(By.xpath("//tbody/tr[1]/td[3]//preceding-sibling::td[2]/button")).click();
		
		
	}
	
	@Test(enabled=false)
	public void testcase4() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)wb;
		
		js.executeScript("document.getElementById('txtUsername').value='Admin'");
		
		js.executeScript("document.getElementById('txtPassword').value='admin123'");

		js.executeScript("document.getElementById('btnLogin').click()");
		
		js.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
		
		js.executeScript("window.scrollBy(0,500)");  // if we want to scroll by co-ordinate
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");  // scroll till the down

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); // scroll back to the top
		
		js.executeScript("document.getElementById('ohrmList_chkSelectRecord_31').scrollIntoView()");
		
	System.out.println(js.executeScript("return document.getElementById('resultTable').innerText"));
	}
	
	@Test(enabled=false)
	public void testcase5() {
		wb.findElement(By.xpath("//*[@id='uploadFile']")).sendKeys("C:\\Users\\user\\Desktop\\dummy.txt");   // to upload any files 
	}
	
	@Test(enabled=false)
	public void testcase6() {
		
		JavascriptExecutor js=(JavascriptExecutor)wb;
		
List<WebElement>	frames=	wb.findElements(By.tagName("iframe"));
System.out.println(frames.size());
for(int i=0;i<frames.size();i++) {
String names=	frames.get(i).getAttribute("id");
System.out.println(names);
}


wb.switchTo().frame("frame2");
js.executeScript("window.scrollBy(0,document.body.scrollHeight)");   // this will scroll down to end of the 2nd frame

  System.out.println(wb.findElement(By.id("sampleHeading")).getText()); 
  
  wb.switchTo().defaultContent();
  
	}
	@Test()
	public void testcase7() {
		Actions act= new Actions(wb);
		//act.contextClick(link).build().perform();
		act.clickAndHold((WebElement) By.xpath("//*[@id='draggable']"));
		//act.dragAndDrop("//*[@id='draggable']", "//*[@id='droppable']");
		
		
	}
	
	@AfterTest
	public void testcase2() {
		//wb.close();
	}
}
