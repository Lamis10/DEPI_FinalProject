package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
//    private By checkText = By.xpath("//*[@id='more-information']/strong") ;
    private By addButton = By.xpath("//*[@id='tbodyid']/div[2]/div/a") ;
    private By productName = By.cssSelector("h2.name");
    private By productPrice = By.cssSelector("#tbodyid > h3");
    private By productDescription = By.cssSelector("#more-information");
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isProductPageVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
        return driver.findElement(productDescription).isDisplayed();
    }
    public void clickAddToCart(){
        driver.findElement(addButton).click();
    }
    public boolean isProductNameVisible(String expectedName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return element.getText().equalsIgnoreCase(expectedName);
    }

    public boolean isProductPriceVisible(String expectedPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return element.getText().contains(expectedPrice);
    }

    public boolean isProductDescriptionVisible(String expectedDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
        return element.getText().contains(expectedDescription);
    }

    public String getAlertTextAndAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }
}
