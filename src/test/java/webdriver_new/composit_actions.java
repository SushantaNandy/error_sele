package webdriver_new;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class composit_actions {
	String url ="https://www.amazon.in/";
	WebDriver driver;
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test()
	public void testcase1() {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		act.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	}

}
