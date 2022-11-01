package webdriver_new;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Simple_commands {
	WebDriver wb;
	public String URL= "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	public String URL1= "https://demo.guru99.com/test/newtours/";
	public String URL2= "https://www.google.com";
	public String URL3= "https://demoqa.com/browser-windows";
	public String URL4= "https://demoqa.com/alerts";
	public String URL5= "https://demoapp.skillrary.com/index.php";
	
	@BeforeTest()
	public void BT() {
		//FirefoxDriver wb= new FirefoxDriver();      // if u want 2 use another web drivers
		WebDriverManager.chromedriver().setup();
		
		wb=new ChromeDriver();
		//wb.manage().window().maximize();            //maximize the window
		
		wb.get(URL5);
		
		//wb.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	@Test(enabled=false,priority=0)
	public void TestCase1() throws InterruptedException {
		
		String ActualTitle="OrangeHRM";
		//Assert.assertEquals(ActualTitle, ExpectedTitle );
		//System.out.println(wb.getPageSource());   // use to get the page source code
		
		//System.out.println(wb.getClass());        // use to get the class
		wb.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");  // gives the username
		wb.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");  // gives the password
		wb.findElement(By.xpath("//*[@id='btnLogin']")).click();   // click on the login button
		wb.findElement(By.xpath("//*[@id='welcome']")).click();    // click on the welcome paul 
		Thread.sleep(2000);         // sleep time duration
		String ExpectedTitle=wb.getTitle();
		if(ExpectedTitle.equals(ActualTitle)) {
			wb.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();  // click on logout
			Thread.sleep(3000);
			}
		else {
			System.out.println("expected in not equal to actual");
		}
		
		
		
		}
	@Test(enabled=false,priority=1)
	
	public void TestCase2() throws InterruptedException {
		WebElement UN =wb.findElement(By.xpath("//*[@id='txtUsername']"));  // I stored an element in a variable
		if(UN.isEnabled()) {           // helps to detect the blockers
			UN.clear();  // if already some data is presence it will clear all those data
			UN.sendKeys("xyz");
			Thread.sleep(3000);
			UN.clear();
			UN.sendKeys("Admin");
			Thread.sleep(3000);
			}
		if(UN.isDisplayed()) {
			wb.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");  // gives the password
		
			wb.findElement(By.xpath("//*[@id='btnLogin']")).click();   // click on the login button
			//wb.findElement(By.xpath("//*[contains(text(),'LOGIN')]")).click();  // click on login button by using text
			
		}
		wb.findElement(By.linkText("PIM")).click();
		wb.findElement(By.linkText("Admin")).click();    // easier way of finding the element BY LINKTEXT LOCATOR
		Thread.sleep(3000);
		//wb.findElement(By.partialLinkText("Re")).click();   // when the link is lengthy
		
		wb.findElement(By.xpath("//*[@id='ohrmList_chkSelectRecord_46']")).click();
		Thread.sleep(3000);
		if(wb.findElement(By.xpath("//*[@id='ohrmList_chkSelectRecord_46']")).isSelected())//to check weather the element is selected or not 
			{
			System.out.println("iteam is selected");
		}
	}
	
	@Test(enabled=false)
	public void testcase3() throws InterruptedException {
		wb.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");  // gives the username
		wb.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");  // gives the password
		wb.findElement(By.xpath("//*[@id='btnLogin']")).click();   // click on the login button
		//String Title =wb.getTitle();
		List<WebElement>	link=	wb.findElements(By.tagName("a"));   // to find the no. of links present under <a> </a> tags

		Thread.sleep(3000);
		System.out.println(link.size());  // print how many links are there 
		for(int i=0;i<link.size();i++) {
			System.out.println(link.get(i).getText());  // use to print the no. of links 
			}
		
	}
	
	@Test(enabled=false)
	public void testcase4() throws InterruptedException {
		wb.findElement(By.xpath("//*[@name='userName']")).sendKeys("nandysushanta8@gmail.com");
		Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@name='password']")).sendKeys("Santosh@3155");
		Thread.sleep(3000);
		wb.findElement(By.xpath("//*[@name='submit']")).click();
		Thread.sleep(3000);
		wb.findElement(By.partialLinkText("Fli")).click();
		Thread.sleep(3000);
	
		//wb.findElement(By.xpath("//*[cointains(text(),'Flights')]")
	}
	@Test(enabled=false)
	public void testcase5() throws InterruptedException {
		
		Thread.sleep(5000);
	}
	@Test(enabled=false)
	public void testcase6() throws InterruptedException, AWTException {
		WebElement link=wb.findElement(By.xpath("(//*[@id='tabButton'])"));
		Thread.sleep(3000);
		link.click();
		Actions act= new Actions(wb);
		act.contextClick(link).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.PAGE_DOWN);
	
		Robot rc = new Robot();         // any key events, any menu activities, we use robot
		Thread.sleep(3000);
		
				// clicking on the first option of the right click
				rc.keyPress(MenuKeyEvent.VK_DOWN);
				rc.keyPress(MenuKeyEvent.VK_ENTER);
				Thread.sleep(3000);
				
				//choosing the second option
				//rc.keyPress(MenuKeyEvent.VK_DOWN);
				
				// to click on the enter button on context click
				rc.keyPress(MenuKeyEvent.VK_ENTER);
				Thread.sleep(3000);
				// to switch tabs
				rc.keyPress(MenuKeyEvent.VK_CONTROL);
				rc.keyPress(MenuKeyEvent.VK_TAB);
				//System.out.println(wb.getTitle());
				//get the handle of one tab, it will store the first window opened
				// it can be for a browser
				//String parentTab = driver.getWindowHandle();
				
				//used to store all the tabs that are opened
				// it will identify how many windows, how many tabs
				
				Set<String> tabs = wb.getWindowHandles();
				
				// for enhanced loop for tabs
				for(String handles: tabs)
				{
					// it will switch to the other tab in the below line
					wb.switchTo().window(handles);
					// gets the title
					System.out.println(wb.getTitle());
				}
		
	
	}
	@Test(enabled=false)
	public void testcase7() throws AWTException, InterruptedException {
		WebElement link=wb.findElement(By.xpath("(//*[@id='tabButton'])"));
		link.click();
		Robot rc = new Robot();         // any key events, any menu activities, we use robot
		Thread.sleep(3000);
		rc.keyPress(MenuKeyEvent.VK_CONTROL);
		rc.keyPress(MenuKeyEvent.VK_TAB);
		Thread.sleep(3000);
		String parentTab = wb.getWindowHandle();
		System.out.println(parentTab);
		Set<String> tabs = wb.getWindowHandles();
		System.out.println(tabs);
		for(int i=0;i<=1;i++)
		{
			wb.findElement(By.id("windowButton")).click();    // to opean the window as many no. of time as much we have the tabs recent opean
			// it will switch to the other tab in the below line
			//wb.switchTo().window(handles);
			Thread.sleep(3000);
		}
		Set<String> tab = wb.getWindowHandles();
		System.out.println(tab);
		for(String handles: tab)
		{
			wb.switchTo().window(handles);
			wb.get(URL);
			System.out.println(wb.getTitle());
			//wb.switchTo().window(parentTab);
		//	wb.get("URL2");
//			wb.close();
		//	wb.switchTo().window(handles);
			//wb.quit();
		}

		wb.switchTo().window(parentTab);
		wb.close();
		//wb.switchTo().window(Strin);
	}
	@Test(enabled=false)
	
	// dealing with slerts
	public void testcase8() throws InterruptedException {
		WebElement link=wb.findElement(By.xpath("(//*[@id='alertButton'])"));
		link.click();
		Thread.sleep(3000);
		Alert bro= wb.switchTo().alert();
		String alertdisplay=bro.getText();
		System.out.println(alertdisplay);
		bro.accept();
		//bro.dismiss();
		Thread.sleep(3000);
		
		
		
		
		WebElement link1=wb.findElement(By.xpath("(//*[@id='timerAlertButton'])"));
		link1.click();
		Thread.sleep(6000);
		Alert bro1= wb.switchTo().alert();
		bro1.accept();
		Thread.sleep(3000);
		
		
		
		WebElement link2=wb.findElement(By.xpath("(//*[@id='confirmButton'])"));	
		link2.click();
		Thread.sleep(3000);
		Alert bro2= wb.switchTo().alert();
		bro2.accept();
		Thread.sleep(10000);
		
		
		
		WebElement link3=wb.findElement(By.xpath("//*[@id='promtButton']"));
		link3.click();
		Thread.sleep(5000);
		Alert bro3= wb.switchTo().alert();
		bro3.sendKeys("sushanta nandy");
		bro3.accept();
		Thread.sleep(3000);
	}
	
	@Test()
	public void testcase9() {
		
	}
	
	
	
	@AfterTest()	
	public void Testcase2() {
		//wb.close();
	}
	
	

}
