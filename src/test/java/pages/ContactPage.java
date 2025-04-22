package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    WebDriver driver ;
    private By checkText = By.xpath("//div/label[contains(text(), 'Contact Email:')]") ;
    private By contactButton = By.linkText("Contact") ;
    private By closeButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]") ; ;
    public ContactPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isContactPageVisible(){
        return driver.findElement(checkText).isDisplayed();
    }
    public void clickContact(){
        driver.findElement(contactButton).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOf( driver.findElement(checkText)));
    }
    public void clickClose(){
        driver.findElement(closeButton).click();
    }
}
