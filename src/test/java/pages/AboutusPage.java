package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutusPage {
    WebDriver driver ;
    private By checkText = By.xpath("//div[@class='modal-header']/h5[contains(text(), 'About us')]") ;
    private By aboutButton = By.linkText("About us") ;
    private By closeButton = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button") ;
    private By close_button= By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");
    ;
    public AboutusPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean isAboutusPageVisible(){
        return driver.findElement(checkText).isDisplayed();
    }
    public void clickAboutus(){
        driver.findElement(aboutButton).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOf( driver.findElement(checkText)));
    }
    public void clickClose(){
        driver.findElement(closeButton).click();
    }
    public void click_close()
    {
        driver.findElement(close_button).click();
    }

}
