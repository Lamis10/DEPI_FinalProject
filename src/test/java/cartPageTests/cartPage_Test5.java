package cartPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import java.time.Duration;
import java.util.regex.Pattern;


public class cartPage_Test5
{
    // Verify "Purchase" Button Only Works When All Fields Are Correctly Filled.
    WebDriver driver;
    CartPage cartPage;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/cart.html");
        cartPage = new CartPage(driver);
    }

    @Test
    public void verifyPurchaseButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textMatches(By.id("totalp"), Pattern.compile("\\d+")));
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
        placeOrderButton.click();

        cartPage.fillOrderForm(
                "Seif Osama",
                "Egypt",
                "Ismailia",
                "1234567890123456",
                "4",
                "2025"
        );
    }
}
