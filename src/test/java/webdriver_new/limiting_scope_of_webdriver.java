package webdriver_new;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class limiting_scope_of_webdriver {
WebDriver driver;
	
	public String URL="https://rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	//1. find total link present in the webpage
	//2. limiting the driver and find links present in footer section
	//3. find links in the the particular column in below footer
	
	@Test()
	public void testcase1() {
		//1.
		
		System.out.println("Total link presences are "+ driver.findElements(By.tagName("a")).size());
	}
	
	@Test()
	public void testcase2() {
		//2.
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));  // this is the way to limit the scope
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//3.
		WebElement footer1 =footer.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
		System.out.println("This is the link for column in footer "+footer1.findElements(By.tagName("a")).size());
	}
	
	
	
}
