package cartPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;

public class cartPage_Test1
{
    //Verify That Product Page Display Detailed Information About The Product ( Name , Price ,Description ).
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
    public void verifyProductDetailsIsVisible()
    {
        String expectedName = "Samsung galaxy s6";
        String expectedPrice = "$360";
        String expectedDescription = "Product description";
        Assert.assertTrue(productPage.isProductNameVisible(expectedName), "Product Name is not visible or incorrect");
        Assert.assertTrue(productPage.isProductPriceVisible(expectedPrice), "Product price is not correct!");
        Assert.assertTrue(productPage.isProductDescriptionVisible(expectedDescription), "Product description is not correct!");
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
