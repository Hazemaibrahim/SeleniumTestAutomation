package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {
	
    public WebDriver driver;
    
	@BeforeTest
	public void setUpTest() {
		
		//setup browser
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

	}

    public void getUrl(String url) {
    	
    	driver.get(url);
    }

    public void enterUsername(String username) {
    	
    	driver.findElement(By.name("uname")).sendKeys(username);
    }

    public void enterPassword(String password) {
    	
    	driver.findElement(By.name("pwd")).sendKeys(password);
    }

    public void clickLoginButton() {
    	
    	driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
    }
    
    public void enterFirstName(String firstName) {
    	
    	driver.findElement(By.name("fname")).sendKeys(firstName);
    }
    
    public void enteLastName(String lastName) {
    	
    	driver.findElement(By.name("lname")).sendKeys(lastName);
    }
    
    public void selectGender() {
    	
    	driver.findElement(By.id("male")).click();
    }
    
    public void selectOneOption() {
    	
    	driver.findElement(By.xpath("//option[@value='option 1']")).click();
    }
    
    public Select selectMultipleOptions() {
    	
    	WebElement dropDown=driver.findElement(By.id("owc"));
    	Select selectObject=new Select(dropDown);
    	return selectObject;
    }
    
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed succesfully");
	}

    
   
 
 
    
}
