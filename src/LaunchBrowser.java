import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LaunchBrowser {

	private WebDriver driver;

	@BeforeClass
	
	//launching the driver
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/home/kapil/workspace/TestNGWithSelenium/drivers/chromedriver");
		driver = new ChromeDriver();

	}
    
	//closing the driver
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	//verify search button
	@Test
	public void verifySearchButton() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.name("btnK"));

		String text = search_button.getAttribute("value");

		Assert.assertEquals(text, search_text, "Text not found!");
	}
}
