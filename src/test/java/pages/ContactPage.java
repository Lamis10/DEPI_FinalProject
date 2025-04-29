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
    private By closeButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]") ;
    private By Email =By.xpath("//*[@id=\"recipient-email\"]");
    private By NAME =By.xpath("//*[@id=\"recipient-name\"]");
    private By message =By.xpath("//*[@id=\"message-text\"]");
    private By message_button= By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
    private By close_button= By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");
    ;
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
    public void write_email(String email)
    {
        driver.findElement(Email).sendKeys(email);
    }
    public void write_NAME(String name)
    {
        driver.findElement(NAME).sendKeys(name);
    }
    public void write_message(String Message)
    {
        driver.findElement(message).sendKeys(Message);
    }

    public void click_message()
    {
        driver.findElement(message_button).click();
    }
    public void click_close()
    {
        driver.findElement(close_button).click();
    }


}
