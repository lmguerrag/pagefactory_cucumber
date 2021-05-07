package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentStepPage {

    private WebDriver driver;
    private By bankWireElement = By.xpath("//a[@class='bankwire']/span[text()='(order processing will be longer)']");

    public PaymentStepPage(WebDriver driver){
        this.driver = driver;
    }

    public SummaryStepPage clickBankWire(){
        driver.findElement(bankWireElement).click();
        return new SummaryStepPage(driver);
    }


}
