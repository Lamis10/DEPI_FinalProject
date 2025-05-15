package productPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;

import java.time.Duration;

public class productPage_Test1
{
    // Verify "Add To Cart" Button And It's Functionality.
    WebDriver driver;
    ProductPage productPage;
    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/prod.html?idp_=1");
        productPage = new ProductPage(driver);
    }

    @Test
    public void verifyAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/div[2]/div/a")));
        productPage.clickAddToCart();

        String alertMessage = productPage.getAlertTextAndAccept();
        Assert.assertEquals(alertMessage, "Product added", "Alert message is wrong!");
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
