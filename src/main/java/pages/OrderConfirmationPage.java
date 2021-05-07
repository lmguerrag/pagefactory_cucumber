package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private WebDriver driver;
    private By confirmationMessage = By.cssSelector("p.cheque-indent strong.dark");

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }

}
