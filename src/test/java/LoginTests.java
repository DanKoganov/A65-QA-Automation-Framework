import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
//another comment added
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//      This is a new comment
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://test";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000); //Added a temporary Thread.sleep for demo purposes
        driver.quit();
    }
}
