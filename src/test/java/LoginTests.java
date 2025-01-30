import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword()  {

        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        loginField.sendKeys("TEst@testpro.io");
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        passwordField.sendKeys("6JooL8gp");
        submitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://testpro.io/");
    }
}
