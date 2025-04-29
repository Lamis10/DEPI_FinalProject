package HomePageTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class CategoriesTest14 {
    WebDriver driver;
    HomePage homePage;
    ProductPage product;
  @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }
    @Test(priority = 1)
    public void verifyProductPageIsVisible(){
        homePage.clickLaptops();
        homePage.clickLaptopProduct();
        product = new ProductPage(driver);
        Assert.assertTrue(product.isProductPageVisible(), "product details page is not visible");
    }
    @Test(priority = 2)
    public void verifyProductAddedMessage(){
           product.clickAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            System.out.println("Alert says: " + alertText);
            Assert.assertEquals(alertText, "Product added");

            alert.accept();

        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared!");
            Assert.fail("Expected alert did not appear");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
