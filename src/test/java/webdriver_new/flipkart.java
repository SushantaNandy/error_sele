package webdriver_new;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {
WebDriver driver;
	
	public String URL="https://www.flipkart.com";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SoftAssert softassert= new SoftAssert();
	}
	@Test()
	public void testcase1(SoftAssert softassert) throws InterruptedException {
		//Relative Xpath:
		
		softassert.assertEquals(driver.getCurrentUrl(),"https://www.fb.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('_2IX_2- VJZDxU')[0].value='sushanta'");
		//driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("9438675290");
		Thread.sleep(3000);
		WebElement web=driver.findElement(By.xpath("//input[@type='password']"));
		web.sendKeys("Santosh@3155");
		//Using of AND
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit' and @class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='_2YULOR']")).getText());
		web.clear();
		Thread.sleep(3000);
		web.sendKeys("santosh3155");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit' and @class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(2000);
		
		// contains
		
		driver.findElement(By.xpath("//a[contains(@class,'_3SkBxJ')]")).click();
		// Xpath Starts-with

		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@class,'_3LxTgx')]/div/div")).getText(),"Total Amount");
		//XPath Text() Function
		Thread.sleep(3000);
		Boolean btn =driver.findElement(By.xpath("//span[text()='Place Order']")).isEnabled();
		assertTrue(btn);
		System.out.println("place order button is enabled");
		driver.navigate().back();
		Thread.sleep(3000);
		//Ancestor:
		
		Boolean txt= driver.findElement(By.xpath("//div[contains(@class,'YUhWwv')]/ancestor::div[4]/div[2]/div[4]/a/span")).isDisplayed();
		assertTrue(txt);
		
		
		//child
		Thread.sleep(3000);
		String str=driver.findElement(By.xpath("//div[contains(@class,'_37M3Pb')]/child::div[2]/a")).getAttribute("href");
		System.out.println(str);
		assertNotNull(str);
		softassert.assertAll();
	}
	@AfterTest()
	public void testcase2() {
		driver.close();
	}

}
