package javascript_exe;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {
	WebDriver driver;
	public String URL="https://rahulshettyacademy.com/AutomationPractice/";

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
			
	}
	@Test()
	public void testcase1() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");       // scroll by co- ordinates
		Thread.sleep(3000);
		
		//it will scroll the inner column inside the web page
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //we are using css here
		//because we have used .tableFixedHead
		
	}
}
