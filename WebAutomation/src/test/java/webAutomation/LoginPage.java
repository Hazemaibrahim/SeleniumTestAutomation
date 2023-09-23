package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
}
