package cartPageTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;


public class cartPage_Test3
{
    // Verify Item Can Be Removed from the Cart.
    WebDriver driver;
    CartPage cartPage;
    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/cart.html");

        cartPage = new CartPage(driver);
        cartPage.waitForCartItemsToLoad();
    }

    @Test
    public void verifyItemCanBeRemoved()
    {
        int initialItemCount = cartPage.getNumberOfItemsInCart();
        cartPage.deleteLastItem();
        int finalItemCount = cartPage.getNumberOfItemsInCart();
        Assert.assertEquals(finalItemCount, initialItemCount - 1, "Item was not removed correctly from the cart.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
