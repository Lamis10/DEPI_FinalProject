package cartPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class cartPage_Test2
{
    // Verify Total Price is Calculated Correctly on Cart Page.
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
    public void verifyTotalPrice()
    {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();

        int calculatedTotal = cartPage.calculateTotalPrice();
        int displayedTotal = cartPage.getDisplayedTotalPrice();

        Assert.assertEquals(calculatedTotal, displayedTotal, "Total price calculation is incorrect!");
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
