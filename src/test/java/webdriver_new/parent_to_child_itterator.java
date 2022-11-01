package webdriver_new;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parent_to_child_itterator {
	String url ="https://rahulshettyacademy.com/seleniumPractise/#/";
	WebDriver driver;
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test()
	public void testcase1() {
		driver.findElement(By.xpath("//*[@class='cart-header-navlink blinkingText']")).click();
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it= windows.iterator();   // 1. parent 2. child
		// first itterator is in the outside and then it will switch to parent and then to child
		String parent = it.next();   // gives the parent id
		String child = it.next();    // gives the child id
		driver.switchTo().window(child);  // switch to child window
		String str=	driver.findElement(By.xpath("//*[@class='im-para red']")).getText();
		System.out.println(str);
		driver.switchTo().window(parent);
	}


}
