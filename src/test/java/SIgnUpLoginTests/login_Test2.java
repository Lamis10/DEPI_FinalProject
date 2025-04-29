package SIgnUpLoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.loginpage;

import java.time.Duration;
//Verify that a user can log in with valid credentials.
public class login_Test2 {
    WebDriver driver;
    HomePage Homepage;
    loginpage Login;

  @BeforeClass	
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(priority = 2)
    public void verify_login() {
        Homepage = new HomePage(driver);
        Homepage.click_login();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModalLabel\"]")));
        Assert.assertTrue(Text.isDisplayed(), "TEST2FAILED");
    }
    @Test(priority = 3)
    public void verify_Enteraccounts() {
        Login = new loginpage(driver);
        Login.write_NAME("mai@2003");
        Login.write_passward("123@maikhaled");
        Login.click_login();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
