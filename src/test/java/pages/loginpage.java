package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
    WebDriver driver;

    private By passward =By.xpath("//*[@id=\"loginpassword\"]");
    private By NAME =By.xpath("//*[@id=\"loginusername\"]");
    private By Login_button= By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private By close_button= By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");

    //constractor
    public loginpage(WebDriver driver)
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

    public void click_login()
    {
        driver.findElement(Login_button).click();
    }
    public void click_close()
    {
        driver.findElement(close_button).click();
    }

}
