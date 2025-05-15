package cartPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class cartPage_Test4
{
    // Verify "Place Order" Button is Present and Functions Correctly.
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
    public void placeOrderButton()
    {
        cartPage.clickPlaceOrderButton();
        Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed(), "Name field not visible");
        Assert.assertTrue(driver.findElement(By.id("country")).isDisplayed(), "Country field not visible");
        Assert.assertTrue(driver.findElement(By.id("city")).isDisplayed(), "City field not visible");
        Assert.assertTrue(driver.findElement(By.id("card")).isDisplayed(), "Credit Card field not visible");
        Assert.assertTrue(driver.findElement(By.id("month")).isDisplayed(), "Month field not visible");
        Assert.assertTrue(driver.findElement(By.id("year")).isDisplayed(), "Year field not visible");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
