package webAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import webAutomation.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases extends LoginPage {
	

	@Test(priority=2)
	public void validloginTest() throws InterruptedException {
		
		//login test with valid credentials
		getUrl("https://trytestingthis.netlify.app/");
		
		enterUsername("test");
		enterPassword("test");
		Thread.sleep(500);
		clickLoginButton();
		Thread.sleep(500);	
	}
	@Test(priority=3)
	public void invalidloginTest() throws InterruptedException {
		
		getUrl("https://trytestingthis.netlify.app/");
		
		//login test with invalid credentials
		enterUsername("invalid");
		enterPassword("invalid");
		Thread.sleep(500);
		clickLoginButton();
		
		//handles the alert the opens when the login fails
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(500);
		alert1.accept();


	}
	@Test(priority=4)
	public void LayoutTwoTest() throws InterruptedException {
		//Tests the layoutTwo
		
		getUrl("https://trytestingthis.netlify.app/");
		
		//enter first and last names
		enterFirstName("John");
		enteLastName("Max");
		Thread.sleep(500);
		
		//select gender type
		selectGender();
		Thread.sleep(500);
		
		//select one option from many options
		selectOneOption();
		Thread.sleep(500);
		
		//creates select object from the selectMultipleoptions method
		Select selectObject = selectMultipleOptions();
		selectObject.selectByVisibleText("Option");
		selectObject.selectByVisibleText("Option 2");
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(500);
		
		//select multiple options
		driver.findElement(By.name("option1")).click();
		driver.findElement(By.name("option2")).click();
		driver.findElement(By.name("option3")).click();
		
		//type orange under start typing checkbox
		driver.findElement(By.name("Options")).sendKeys("orange");
		Thread.sleep(500);
		
		//select favorite color
		WebElement colorElement=driver.findElement(By.name("favcolor"));
		
		//set the color to black
		String colorCode="#000000";
		colorElement.sendKeys(colorCode);
		
		//select a date
		driver.findElement(By.name("day")).sendKeys("6/06/2023");
		
		// Locate the file input element by its ID
        WebElement fileInput = driver.findElement(By.id("myfile"));

        // Provide the local file path to upload
        String filePath = "C:\\Users\\Lenovo\\Desktop\\results2.csv";
        fileInput.sendKeys(filePath);

        // set the quantity to 4
        driver.findElement(By.id("quantity")).sendKeys("4");
        Thread.sleep(500);
        
        //clear the written message and enter new long message
        WebElement longMessage=driver.findElement(By.name("message"));
        longMessage.clear();
        longMessage.sendKeys("This message is added using automation script");
        Thread.sleep(500);
       
        //click on submit button which opens google.com new tab
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        Thread.sleep(1000);
		
	}
	@Test(priority=1)
	public void layoutOneTest() throws InterruptedException {
		//Tests the layoutOne
		
		getUrl("https://trytestingthis.netlify.app/");
		
		//Click on alert button and verify the response from the website
		driver.findElement(By.cssSelector("button[onclick='alertfunction()']")).click();
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(500);
		alert1.accept();
		
		Thread.sleep(500);
		//double click on the double click button
		
        // Locate the element to double-click
        WebElement elementToDoubleClick = driver.findElement(By.cssSelector("button[ondblclick='myFunction()']")); // Replace with the actual element locator

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform the double-click action on the element
        actions.doubleClick(elementToDoubleClick).perform();
        
        Thread.sleep(500);
        
        //demo to drag the pizza image to the pizza box
        WebElement pizzaImage=driver.findElement(By.id("drag1"));
        WebElement pizzaBox=driver.findElement(By.id("div1"));
        actions.dragAndDrop(pizzaImage, pizzaBox);
        actions.build().perform();
        Thread.sleep(500);
        
        
   
		
		
		
	}

		
}
