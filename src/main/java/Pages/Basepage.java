package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;

public class Basepage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public Basepage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ========================
    // Common Reusable Methods
    // ========================

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
      
    }

    protected void type(By locator, String text) {
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
       
    }

    protected boolean isDisplayed(By locator) {
        try {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }
        catch(Exception e) {
        return false;
        }
    }
    

    protected void jsClick(By locator) {
    	 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    protected void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}