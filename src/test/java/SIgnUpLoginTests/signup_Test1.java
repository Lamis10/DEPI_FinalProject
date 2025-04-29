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
import pages.signup_page;

import java.time.Duration;
//verify signup page open correctly

public class signup_Test1 {
        WebDriver driver;
        HomePage Homepage;
        signup_page Signup;

      @BeforeClass	
        public void setup() {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.demoblaze.com/index.html");
        }
        @Test(priority = 2)
        public void verify_signup() {
            Homepage = new HomePage(driver);
            Homepage.click_signup();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInModalLabel\"]")));
            Assert.assertTrue(Text.isDisplayed(), "TEST2FAILED");
        }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
