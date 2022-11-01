package webdriver_new;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drop_down {

	String url1 = "https://rahulshettyacademy.com/dropdownsPractise/";
	String url2 = "https://rahulshettyacademy.com/AutomationPractice/";

	WebDriver driver;

	@BeforeTest()
	public void testcase0() {

		WebDriverManager.chromedriver().setup(); // for chrome
		driver = new ChromeDriver();
		driver.get(url2);

	}

	@Test(enabled = false)
	public void testcase1() {
		// Dropdown practise
		// static dropdown --> select , so dropdown with select tag, some dropdown may
		// be in anchor tag but here we need to use select tag
		WebElement static_drop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(static_drop);
		dropdown.selectByIndex(2); // to select the dropdown as per index
		System.out.println(dropdown.getFirstSelectedOption().getText()); // used to findout which option is selected at
																			// the time
																			// -->dropdown.getFirstSelectedOption()

		// selcting using visible text
		dropdown.selectByVisibleText("INR");
	}

	@Test(enabled = false)
	public void testcase2() throws InterruptedException {

		// for auto suggestion dropdown

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options)

		{

			if (option.getText().equalsIgnoreCase("India"))

			{

				option.click();

				break;

			}

		}
	}

	@Test(enabled=false)

	// count number of checkboxes
	public void testcase4() {
		System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
	}
	
	@Test(enabled=true)
	public void testcase6() {
	String str= driver.findElement(By.id("checkBoxOption1")).getText();
	 System.out.println(str);
}

	@AfterTest(enabled = false)
	public void testcase3() {
		driver.close();

	}

}
