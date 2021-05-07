package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiter;

public class CartPage {

    private WebDriver driver;
    private Waiter wait;
    private By productReference = By.xpath("//small[text()='SKU : demo_4']");
    private By proceedButton = By.xpath("//span[text()='Proceed to checkout']");

    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new Waiter(driver);
    }

    public String getProductReference(){
        return driver.findElement(productReference).getText();
    }

    public AddressStepPage clickProceedButtonPassLogin(){
        driver.findElement(proceedButton).click();
        return new AddressStepPage(driver);
    }

    public SignInStepPage clickProceedButtonWithLogin(){
        driver.findElement(proceedButton).click();
        return new SignInStepPage(driver);
    }

}
