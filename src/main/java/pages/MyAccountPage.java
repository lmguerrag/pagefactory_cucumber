package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;
    private By accountLoginMessage = By.className("info-account");

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAccountLoginMessage(){
        return driver.findElement(accountLoginMessage).getText();
    }


}
