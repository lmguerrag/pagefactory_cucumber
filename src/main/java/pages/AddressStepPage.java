package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressStepPage {

    private WebDriver driver;
    private By proceedButtonOnAddress = By.xpath("//span[text()='Proceed to checkout']");

    public AddressStepPage(WebDriver driver){
        this.driver = driver;
    }

    public ShippingStepPage clickProceedButtonOnAddressStep(){
        driver.findElement(proceedButtonOnAddress).click();
        return new ShippingStepPage(driver);
    }
}
