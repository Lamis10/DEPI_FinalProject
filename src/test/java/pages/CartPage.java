package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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

    public int calculateTotalPrice() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector("#tbodyid tr td:nth-child(3)"));
        int calculatedTotal = 0;
        for (WebElement priceElement : priceElements) {
            calculatedTotal += Integer.parseInt(priceElement.getText().trim());
        }
        return calculatedTotal;
    }

    public int getDisplayedTotalPrice() {
        String totalText = driver.findElement(By.id("totalp")).getText();
        if (totalText == null || totalText.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(totalText);
    }

    public int getNumberOfItemsInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
        List<WebElement> items = driver.findElements(By.xpath("//tbody/tr"));
        return items.size();
    }

    public void deleteLastItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> items = driver.findElements(By.cssSelector("#tbodyid > tr"));
        if (items.isEmpty()) {
            throw new NoSuchElementException("No items found in the cart.");
        }
        WebElement lastRow = items.get(items.size() - 1);
        WebElement deleteButton = lastRow.findElement(By.linkText("Delete"));
        deleteButton.click();

        wait.until(ExpectedConditions.stalenessOf(lastRow));
    }

    public void waitForCartItemsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#tbodyid > tr"), 0));
    }

    public void clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
        placeOrderButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
    }

    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(creditCard);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);

        WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
        purchaseButton.click();
    }
}
