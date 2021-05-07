package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingStepPage {

    private WebDriver driver;
    private By termsOfServiceCheckbox = By.id("uniform-cgv");
    private By proceedButtonOnShippingStep = By.xpath("//button[@name='processCarrier']");

    public ShippingStepPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTermsOfServiceCheckbox(){
        driver.findElement(termsOfServiceCheckbox).click();
    }

    public PaymentStepPage clickProceedOnShippingStep(){
        driver.findElement(proceedButtonOnShippingStep).click();
        return new PaymentStepPage(driver);
    }

}
