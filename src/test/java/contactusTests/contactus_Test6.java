package contactusTests;

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
import pages.ContactPage;
import pages.HomePage;
import pages.loginpage;

import java.time.Duration;
//Verify the contact Close button functionality
public class contactus_Test6 {

    WebDriver driver;
    HomePage Homepage;
    ContactPage Contact;

  @BeforeClass	
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(priority = 2)
    public void verify_contact() {
        Homepage = new HomePage(driver);
        Homepage.click_contact();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"exampleModalLabel\"]")));
        Assert.assertTrue(Text.isDisplayed(), "TEST2FAILED");
    }
    @Test(priority = 3)
    public void signup_close(){
        Contact = new ContactPage(driver);
        Contact.click_close();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
