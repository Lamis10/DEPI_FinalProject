package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    WebDriver driver ;
    private By checkText = By.linkText("CATEGORIES") ;
    private By homeButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a") ;
    private By phonesSection = By.xpath("//*[contains(@id, 'itemc') and contains(text(), 'Phones')]");
    private By laptopsSection = By.xpath("//*[contains(@id, 'itemc') and contains(text(), 'Laptops')]") ;
    private By monitorsSection = By.xpath("//*[contains(@id, 'itemc') and contains(text(), 'Monitors')]") ;
    private By laptopProduct = By.xpath("//div/h4/a[contains(text(), 'Sony vaio i5')]") ;
    private By defaultCategotyProduct = By.xpath("//div/h4/a[contains(text(), 'Nexus 6')]") ;
    private By nextButton = By.xpath("//*[@id=\"next2\"]") ;
    private By prevButton = By.xpath("//*[@id=\"prev2\"]") ;
    private By rightArrow = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]") ;
    private By leftArrow = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]") ;
    private By categoriesLink = By.xpath("//*[@id=\"cat\"]") ;
    private By image3rdButton = By.xpath("//*[@id=\"carouselExampleIndicators\"]/ol/li[3]") ;
    private By login_button= By.linkText("Log in");
    private By signup_button= By.linkText("Sign up");
    private By aboutUs_button= By.linkText("About us");
    private By contact_button= By.linkText("Contact");




    public List<String> laptopNames = Arrays.asList(
            "MacBook air", "Dell i7 8gb", "2017 Dell 15.6 Inch", "MacBook Pro","Sony vaio i5","Sony vaio i7"
    );
    public List<String> phoneNames = Arrays.asList(
            "Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "MacBook Pro","Samsung galaxy s7","Iphone 6 32gb","Sony xperia z5","HTC One M9"
    );
    public List<String> monitorsNames = Arrays.asList(
            "Apple monitor 24", "ASUS Full HD"
    );
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isHomePageVisible(){
        return driver.findElement(checkText).isDisplayed();
    }
    public void clickHome(){
        driver.findElement(homeButton).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(defaultCategotyProduct));
    }
    public boolean isPhonesVisible(){
        return driver.findElement(phonesSection).isDisplayed();
    }
    public boolean isLaptopsVisible(){
        return driver.findElement(laptopsSection).isDisplayed();
    }
    public boolean isMonitorsVisible(){
        return driver.findElement(monitorsSection).isDisplayed();
    }
    public void clickPhones(){
        driver.findElement(phonesSection).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(laptopProduct));
    }
    public void clickLaptops(){
        driver.findElement(laptopsSection).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h4/a[contains(text(), 'MacBook air')]")));
    }
    public void clickMonitors(){
        driver.findElement(monitorsSection).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a[contains(text() , 'Apple monitor 24')]")));
    }
    public void clickLaptopProduct(){
        driver.findElement(laptopProduct).click();
    }
    public boolean isDefaultCategotyProductVisible(){
        return driver.findElement(defaultCategotyProduct).isDisplayed();
    }
    public void clickNextButton(){
        Actions action = new Actions(driver);
        action.scrollByAmount(0,500).perform();
        driver.findElement(nextButton).click();
    }
    public boolean isPrevVisible(){
        return driver.findElement(prevButton).isDisplayed();
    }
    public void clickRightArrow(){
        driver.findElement(rightArrow).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[2]/img")));
    }
    public boolean isNextPictureVisible(){
        return driver.findElement(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[2]/img")).isDisplayed();
    }
    public void clickLeftArrow(){
        driver.findElement(leftArrow).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[3]/img")));
    }
    public boolean isPrevPictureVisible(){
        return driver.findElement(By.xpath("//*[@id=\"carouselExampleIndicators\"]/div/div[3]/img")).isDisplayed();
    }
    public void clickPrev(){
        driver.findElement(prevButton).click();
    }
    public void clickCategories(){
        driver.findElement(categoriesLink).click();
    }
    public void clickImage3rd(){
        driver.findElement(image3rdButton).click();
    }
    public void click_login()
    {
        driver.findElement(login_button).click();
    }
    public void click_signup()
    {
        driver.findElement(signup_button).click();
    }
    public void click_aboutUs()
    {
        driver.findElement(aboutUs_button).click();
    }
    public void click_contact()
    {
        driver.findElement(contact_button).click();
    }


}
