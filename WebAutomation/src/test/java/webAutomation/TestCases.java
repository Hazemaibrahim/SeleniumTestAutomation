package webAutomation;

import org.openqa.selenium.By;
import webAutomation.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeTest
	public void setUpTest() {
		//setup browser
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	
	@Test(priority=1)
	public void validloginTest() throws InterruptedException {
		//login test with valid credentials
		loginPage.getUrl("https://trytestingthis.netlify.app/");
		loginPage.enterUsername("test");
		Thread.sleep(1000);
		loginPage.enterPassword("test");
		Thread.sleep(1000);
		loginPage.clickLoginButton();
		Thread.sleep(1000);	
	}
	@Test(priority=2)
	public void invalidloginTest() throws InterruptedException {
		//login test with invalid credentials
		loginPage.getUrl("https://trytestingthis.netlify.app/");
		loginPage.enterUsername("invalid");
		Thread.sleep(1000);
		loginPage.enterPassword("invalid");
		Thread.sleep(1000);
		loginPage.clickLoginButton();
		WebElement errorMessage = driver.findElement(By.id("Wrong Credentials! Try again!")); 
		Assert.assertTrue(errorMessage.isDisplayed(), "Login failed");

	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed succesfully");
	}

		
}
