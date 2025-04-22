package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    private By checkText = By.xpath("//*[@id=\"more-information\"]/strong") ;
    private By addButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a") ;
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isProductPageVisible(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(checkText));
        return driver.findElement(checkText).isDisplayed();
    }
    public void clickAddToCart(){
        driver.findElement(addButton).click();
    }
}
