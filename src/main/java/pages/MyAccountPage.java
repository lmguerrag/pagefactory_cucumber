package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;
    private By accountLoginMessage = By.className("info-account");
    private By homePageButton = By.className("icon-home");

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAccountLoginMessage(){
        return driver.findElement(accountLoginMessage).getText();
    }

    public void clickHomePageButton(){ driver.findElement(homePageButton).click(); }
}
