package HomePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesTest21 {
    WebDriver driver;
    HomePage homePage;
  @BeforeClass	
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }
    @Test
    public void verifySameProductsAppearAfterPrev(){
        List<WebElement> page1Products = driver.findElements(By.className("card-title"));
        Actions action = new Actions(driver);
        action.scrollByAmount(0,500).perform();

        homePage.clickNextButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));

        homePage.clickPrev();
         wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")));

        List<WebElement> page2Products = driver.findElements(By.className("card-title"));
        for (WebElement title : page2Products) {
            String productName = title.getText();
            if (!page1Products.contains(productName)) {
                throw new AssertionError("product changed");
            }
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
