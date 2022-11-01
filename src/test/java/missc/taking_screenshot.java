package missc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class taking_screenshot {
	WebDriver driver;
	public String URL="https://www.webroot.com/services/popuptester1.htm";
	
	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
}
	@Test()
	public void testcase1() throws IOException {
		
		// it will capture the screen-shot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/Users/user/Desktop/seleniumshots/second.png"));  
	}
}