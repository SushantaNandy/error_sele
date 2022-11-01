package missc;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class deleting_cookies {
	WebDriver driver;
	public String URL="https://www.webroot.com/services/popuptester1.htm";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();  //to accept insecure cert to accept automatically for chrome
		option.setAcceptInsecureCerts(true);
		
		//used for pop up to block
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		driver=new ChromeDriver(option);
		driver.get(URL);
				
}
		@Test()
		public void testcase1() {
			
		}
}
