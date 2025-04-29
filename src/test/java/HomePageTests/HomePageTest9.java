package HomePageTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class HomePageTest9 {
    HomePage homePage;
    WebDriver driver;
  @BeforeClass	
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void verifyImagesChangeEvery7Seconds() throws InterruptedException {

        List<WebElement> images = driver.findElements(By.xpath("//div/img[@class='d-block img-fluid']"));

        String firstImageSrc = "";
        for (WebElement img : images) {
            if (img.isDisplayed()) {
                firstImageSrc = img.getAttribute("src");
                break;
            }
        }
        System.out.println("First image src: " + firstImageSrc);

        Thread.sleep(7000);

        String secondImageSrc = "";
        for (WebElement img : images) {
            if (img.isDisplayed()) {
                secondImageSrc = img.getAttribute("src");
                break;
            }
        }
        System.out.println("Second image src: " + secondImageSrc);

        if (firstImageSrc.equals(secondImageSrc)) {
            throw new AssertionError("Image did not change after 7 seconds.");
        } else {
            System.out.println("Image changed successfully.");
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
