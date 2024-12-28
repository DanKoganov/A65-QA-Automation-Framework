package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I open login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }


    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }
    @And("I submit")
    public void clickSubmit() {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }
    @Then("I logged in")
    public void userLoggedIn(){
        Assert.assertTrue(wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @When("I click Forgot Password")
    public void iClickForgotPassword() {
        wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[href='registration']"))).click();
    }

//    @And("I enter email {string}")
//    public void iEnterEmailEmail(String email) {
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
//    }

    @Then("I expect a message {string}")
    public void iExpectAMessage(String text) {
        Assert.assertEquals(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".messages"))).getText(),text);
    }
}
