package missc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenlink {
WebDriver driver;
	
	public String URL="https://rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeTest()
	public void testcase()  {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test()
	public void testcase2() throws InterruptedException, MalformedURLException, IOException {
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));  // this is the way to limit the scope
		System.out.println(footer.findElements(By.tagName("a")).size());
		List<WebElement> links=	footer.findElements(By.tagName("a"));
		
		for(int i=1; i<links.size(); i++) {
			String url= links.get(i).getAttribute("href");
			System.out.println(url);
			
			//method in java to check weather the url is working or not --> openConnection
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();								// connect with the urls
			int response_code= conn.getResponseCode();   //fetch the response codes
			System.out.println(response_code);
			
			}
		    driver.close();
	
	}
}
