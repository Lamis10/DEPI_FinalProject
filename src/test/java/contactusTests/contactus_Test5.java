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

import java.time.Duration;

public class contactus_Test5 {
    //Verify the required fields validation
    //contact us with valid email and  entering name and not entering message
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
    public void verify_Enteraccounts() {
        Contact = new ContactPage(driver);
        Contact.write_email("hanaayman");
        Contact.write_NAME("hana");
        Contact.click_message();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert: " + alertText);

            Assert.fail("Expected validation to reject empty message, but got alert: " + alertText);
        } catch (Exception e) {
            System.out.println("No alert appeared — form did not submit with empty message (correct behavior).");
            Assert.assertTrue(true);
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
