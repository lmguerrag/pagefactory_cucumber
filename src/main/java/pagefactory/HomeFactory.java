package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class HomeFactory {

    private WebDriver driver;

    public HomeFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement loginButton;

    public void clickLoginButton(){
        loginButton.click();
    }

}
