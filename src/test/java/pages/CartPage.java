package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver ;
    private By checkText = By.xpath("//div[@class='col-lg-1']/button[contains(text(), 'Place Order')]") ;
    private By cartButton = By.linkText("Cart") ;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isCartPageVisible(){
        return driver.findElement(checkText).isDisplayed();
    }
    public void clickCart(){
        driver.findElement(cartButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkText));
    }
}
