package webdriver_new;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {
	WebDriver driver;
	
	public String URL="https://demoqa.com/droppable";
	public String URL1="https://the-internet.herokuapp.com/nested_frames";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testcase1() throws InterruptedException {
		System.out.println(driver.findElements(By.tagName("iframe")).size());  //used for frame count
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]")));
		//driver.switchTo().frame(driver.findElement(By.id("droppableContainer")));
		//driver.switchTo().frame("droppableExample-tabpane-simple");
		//driver.findElement(By.id("//*[@id='droppable']")).click();
		
	}
}
