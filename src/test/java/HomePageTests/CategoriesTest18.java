package HomePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class CategoriesTest18 {
    WebDriver driver;
    HomePage homePage;

  @BeforeClass	
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

    }
    @Test
    public void verifyOnlyPhonesAppear(){
        homePage = new HomePage(driver);
        homePage.clickPhones();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div/h4/a[contains(text(), 'Sony vaio i5')]")));
        List<String> phoneNames = homePage.phoneNames;
        List<WebElement> productTitles = driver.findElements(By.className("card-title"));
        for (WebElement title : productTitles) {
            String productName = title.getText();
            System.out.println(productName);

            if (!phoneNames.contains(productName)) {
                throw new AssertionError("Unexpected product in phones section: " + productName);
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
