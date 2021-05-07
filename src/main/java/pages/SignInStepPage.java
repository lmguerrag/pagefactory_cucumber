package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInStepPage {

    private WebDriver driver;
    private By emailCartField = By.id("email");
    private By passwordCartField = By.id("passwd");
    private By signInCartButton = By.id("SubmitLogin");

    public SignInStepPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailCartField(){
        driver.findElement(emailCartField).sendKeys("luis@example.com");
    }

    public void setPasswordCartField(){
        driver.findElement(passwordCartField).sendKeys("123456");
    }

    public AddressStepPage clickSignButton(){
        driver.findElement(signInCartButton).click();
        return new AddressStepPage(driver);
    }

}
