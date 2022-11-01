package missc;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handling_https_certificate {
	WebDriver driver;
	public String URL="https://untrusted-root.badssl.com/";

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();  //to accept insecure cert to accept automatically for chrome
		FirefoxOptions option1 =new FirefoxOptions();  // for firefox
		option.setAcceptInsecureCerts(true);
		option1.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(option);
		driver.get(URL);
			
	}
	@Test()
	public void testcase1() throws InterruptedException {
		 System.out.println(driver.getTitle());
		
	}
}
