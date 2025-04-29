package aboutusTests;

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
import pages.AboutusPage;
import pages.HomePage;
import pages.loginpage;

import java.time.Duration;

public class aboutUs_Test {

    WebDriver driver;
    HomePage Homepage;
    AboutusPage AboutUs;

  @BeforeClass	
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(priority = 2)
    //verfiy that about us page opens correctly
    public void verify_aboutUs() {
        Homepage = new HomePage(driver);
        Homepage.click_aboutUs();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement videoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='example-video']/div[5]/div")));
        Assert.assertFalse(videoModal.isDisplayed(), "TEST2FAILED");


        AboutUs = new AboutusPage(driver);
        AboutUs.click_close();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
