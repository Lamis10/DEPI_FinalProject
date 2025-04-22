package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class CategoriesTest14 {
    WebDriver driver;
    HomePage homePage;
    ProductPage product;
    @BeforeTest
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
        try {
            Alert alert = driver.switchTo().alert();

            String alertText = alert.getText();
            System.out.println("Alert says: " + alertText);


            Assert.assertEquals(alertText, "Product added");

            alert.accept();

        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared!");
        }
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
