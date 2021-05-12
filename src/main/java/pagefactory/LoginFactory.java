package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

public class LoginFactory {

    private WebDriver driver;

    public LoginFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailField;

    @FindBy(id = "SubmitCreate")
    WebElement createButton;

    @FindBy(css = "form#account-creation_form div:nth-child(1) > h3")
    WebElement message;

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public String getMessage(){
        return message.getText();
    }


}
