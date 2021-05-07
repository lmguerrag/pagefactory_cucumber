package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private WebDriverWait wait;
    private WebDriver driver;

    public Waiter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public void waitForElementPresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }


}
