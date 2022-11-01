package missc;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class popup_blocker {
	
		WebDriver driver;
		public String URL="https://www.webroot.com/services/popuptester1.htm";

		@BeforeTest()
		public void testcase() {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get(URL);
					
	}
		@Test()
		public void testcase1() {
			driver.manage().deleteAllCookies();  //used for deleating all the cookies
			driver.manage().deleteCookieNamed("abcd");  //deleat specific cookie
		}

}
