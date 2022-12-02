package SeleniumTest;

import static org.junit.Assert.*;


import org.junit.Test;
import static org.junit.Assert.assertEquals;



import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class BusinessOpportunityTets {

	

		
		private WebDriver driver;
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:3000");
		}

	@Test
	public void loginFailureThenSuccessfull() throws InterruptedException {
		WebElement user = driver.findElement(By.id("user"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		Thread.sleep(2000);
		// Failure case
		user.sendKeys("admin");
		password.sendKeys("1234");
		
		submit.click();
		
		Thread.sleep(2000);
		
		user.clear();
		password.clear();
		user.sendKeys("Solera@solera.com");
		password.sendKeys("Bootcamp4");
		
		submit.click();
		WebElement response = driver.findElement(By.id("placeholder"));
		String test = response.getText();
		assertEquals("lorem ipsum dolor est",test);
	}

}
