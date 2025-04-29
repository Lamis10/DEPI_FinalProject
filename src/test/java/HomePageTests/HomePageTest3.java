package HomePageTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AboutusPage;
import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;

public class HomePageTest3 {
    HomePage homePage;
    AboutusPage about;
    CartPage cart;
    ContactPage contact;
    WebDriver driver;
  @BeforeClass	
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LAMIS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void verifyHomePageVisible(){
        homePage = new HomePage(driver);
        homePage.clickHome();
        Assert.assertTrue(homePage.isHomePageVisible() , "home page is not visible");
    }
    @Test
    public void verifyAboutusPageVisible(){
        about = new AboutusPage(driver);
        about.clickAboutus();
        Assert.assertTrue(about.isAboutusPageVisible() , "about us page is not visible");
        about.clickClose();
    }
    @Test
    public void verifyCartPageVisible(){
        cart = new CartPage(driver);
        cart.clickCart();
        Assert.assertTrue(cart.isCartPageVisible() , "cart page is not visible");
    }
    @Test
    public void verifyContactPageVisible(){
        contact = new ContactPage(driver);
        contact.clickContact();
        Assert.assertTrue(contact.isContactPageVisible() , "contact page is not visible");
        contact.clickClose();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
