package webdriver_new;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class class1 {
	String url = "https://www.facebook.com/"; 
	String url1 = "https://rahulshettyacademy.com/";
	String url2 = "https://t.me/joinchat/UKDuiCJi-pPpv_9a";
	String url3 = "https://rahulshettyacademy.com/locatorspractice";
	String url4 = "https://rahulshettyacademy.com/dropdownsPractise/";

	WebDriver name;

	@BeforeTest()
	public void testcase0() {

		WebDriverManager.chromedriver().setup(); // for chrome
		name = new ChromeDriver();

		// Implicit wait syntex -> it is globally applied in the whole code
		name.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//	WebDriverManager.iedriver().setup();     // for ie
//	 name= new InternetExplorerDriver();

//	WebDriverManager.firefoxdriver().setup();    // for firefox
//	name = new FirefoxDriver();

//	WebDriverManager.edgedriver().setup();     // for edge
//	name= new EdgeDriver();

		// name.manage().window().maximize();

		name.get(url4);
	}

//Explicite wait
	WebDriverWait w = new WebDriverWait(name, 5);

	@Test(enabled = false, timeOut = 3000) // timeOut is TestNG fetaure which tell us in how much second that particular
											// test need to get PASSED

	public void testcase1() throws InterruptedException {

		// Explicite wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));

		name.findElement(By.xpath("//*[@id='email']")).sendKeys("vinod@gmail.com");
		// Thread.sleep(4000);

		name.findElement(By.xpath("//*[@id='pass']")).sendKeys("vinod@123");
		name.findElement(By.xpath(
				"//*[@name='login' and @type='submit' and @class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"))
				.click();
		// Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void testcase2() throws InterruptedException {
		Thread.sleep(3000);
		name.findElement(By.partialLinkText("JOIN")).click();
	}

	@Test(enabled = false)
	public void testcase4() {
		// System.out.println(name.findElement(By.tagName("p")).getText());
		System.out.println(name.findElement(By.xpath("//*[@class='overlay-panel overlay-right']/p")).getText());
		String op = name.findElement(By.xpath("//*[@class='overlay-panel overlay-right']/p")).getText();

		String[] op1 = op.split("your "); // spliting of string
		String[] op2 = op1[1].split(" ");
		System.out.println(op2[0]);

		// Assert.assertEquals(name.findElement(By.xpath("//*[@class='overlay-panel
		// overlay-right']/p")).getText(), "An Academy to Learn Earn & Shine in your QA
		// Career");
	}

	@Test(enabled = false)
	public void testcase5() {
		// following sibling
		System.out.println(name
				.findElement(By.xpath(
						"//div[@class='navbar-collapse collapse clearfix'][1]/ul/li[6]/following-sibling::li[2]"))
				.getText());

		// preciding sibling
		System.out.println(name
				.findElement(By.xpath(
						"//div[@class='navbar-collapse collapse clearfix'][1]/ul/li[6]/preceding-sibling::li[2]"))
				.getText());
	}

	@AfterTest(enabled = true)
	public void testcase3() {
		name.close();

	}

}
