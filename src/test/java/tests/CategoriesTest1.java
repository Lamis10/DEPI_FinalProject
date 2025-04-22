package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class CategoriesTest1 {
    WebDriver driver;
    HomePage homePage;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }
    @Test
    public void verifyPhoneSectionIsVisible(){
        Assert.assertTrue(homePage.isPhonesVisible() , "phones section is not visible");
    }
    @Test
    public void verifyLaptopsSectionIsVisible(){
        Assert.assertTrue(homePage.isLaptopsVisible() , "laptop section is not visible");
    }
    @Test
    public void verifyMonitorsSectionIsVisible(){
        Assert.assertTrue(homePage.isMonitorsVisible(), "monitor section is not visible");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
