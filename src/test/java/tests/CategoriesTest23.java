package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class CategoriesTest23{
    WebDriver driver;
    HomePage homePage;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(priority = 1)
    public void verifyWebsiteLoadedSuccess(){
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible() , "website did not load successfully");
    }
    @Test(priority = 2)
    public void verifyPriceMatching(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h5")));

        String p1 =  driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h5")).getText();
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")).click();

         wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));

        String p2 =  driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3")).getText();
        String priceOnly = p2.split(" ")[0];
        System.out.println(p1 +" " +priceOnly);
        Assert.assertTrue(p1.equals(priceOnly) , "prices do not match");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
