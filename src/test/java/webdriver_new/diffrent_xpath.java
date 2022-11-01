package webdriver_new;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class diffrent_xpath {
WebDriver driver;
	
	public String URL="https://demo.guru99.com/test/selenium-xpath.html";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test()
	public void testcase1() {
		
		//1. Absolute XPath:
		String str= driver.findElement(By.xpath("//html/body/div[4]/div[1]/div/h4[1]")).getText();
		System.out.println(str);
		
		//2. Relative Xpath:
		String str1= driver.findElement(By.xpath("//div[@class='featured-box cloumnsize1']/h4[1]")).getText();
		System.out.println(str1);
		
		//3.Dynamic XPath
		//a.Basic XPath:
		String str3= driver.findElement(By.xpath("//input[@name='password']")).getAttribute("type");
		System.out.println(str3);
		
		//b. Contains():
		String str4= driver.findElement(By.xpath("//input[contains(@type,'sub')]")).getAttribute("value");
		System.out.println(str4);
		
		//c.Using of AND
		String str5=driver.findElement(By.xpath("//input[contains(@name,'btn') and (@type='reset')]")).getAttribute("value");
		System.out.println(str5);
	
		//d. Xpath Starts-with
		String str6=driver.findElement(By.xpath("//input[starts-with(@type,'pass')]")).getAttribute("name");
		System.out.println(str6);
		
		//4. XPath Text() Function
		Boolean b= driver.findElement(By.xpath("//td[text()='Password']")).isDisplayed();
		System.out.println(b);
		
		//5.  XPath axes methods:
		// a.  Following:
		Boolean b1= driver.findElement(By.xpath("//input[@type='text']/following::input[2]")).isEnabled();
		System.out.println(b1);
		
		//b.Ancestor:
		String str7 =driver.findElement(By.xpath("//input[@type='text']/ancestor::form")).getAttribute("name");
		System.out.println(str7);
		
		//c. Child:
		int num=driver.findElements(By.xpath("//ul[@id='java_technologies']/child::li")).size();
		System.out.println(num);
		
		//d. Self:
		driver.findElement(By.xpath("//input[@type='text']/self::input")).sendKeys("sush");
		
	}
	@Test()
	public void testcase2() {
		driver.close();
	}
}
