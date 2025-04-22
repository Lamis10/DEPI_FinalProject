package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AboutusPage;
import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class HomePageTest13 {
    HomePage homePage;
    WebDriver driver;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void verifyImagesChange()  {
        homePage = new HomePage(driver);
        homePage.clickImage3rd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[3]/img")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[3]/img")).isDisplayed() , "picture did not change");

    }
//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }



}
