package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class HomePageTest12 {
    HomePage homePage;
    WebDriver driver;
    CartPage cart;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void verifyProductStoreWorks(){
        cart=new CartPage(driver);
        homePage=new HomePage(driver);
        cart.clickCart();
        driver.findElement(By.xpath("//*[@id=\"nava\"]")).click();
        Assert.assertTrue(homePage.isHomePageVisible() , "home page is not visible");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
