package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signup_page {
    WebDriver driver;

    private By passward =By.xpath("//*[@id=\"sign-password\"]");
    private By NAME =By.xpath("//*[@id=\"sign-username\"]");
    private By signup_button= By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    private By close_button= By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");

    //constractor
    public signup_page(WebDriver driver)
    {
        this.driver=driver;
    }

    public void write_passward(String pass)
    {
        driver.findElement(passward).sendKeys(pass);
    }
    public void write_NAME(String name)
    {
        driver.findElement(NAME).sendKeys(name);
    }

    public void click_signupp()
    {
        driver.findElement(signup_button).click();
    }

    public void click_close()
    {
        driver.findElement(close_button).click();
    }
}
