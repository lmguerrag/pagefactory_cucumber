package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryStepPage {

    private WebDriver driver;
    private By confirmOrderButton = By.xpath("//span[text()='I confirm my order']/ancestor::button");

    public SummaryStepPage(WebDriver driver){
        this.driver = driver;
    }

    public OrderConfirmationPage clickConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
        return  new OrderConfirmationPage(driver);
    }
}
