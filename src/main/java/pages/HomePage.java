package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    private By popularProducts = By.cssSelector("ul#homefeatured div.product-container");
    private By signInButton = By.className("login");
    private By logoutButton = By.className("logout");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public AuthenticationPage clickSignInButton(){
        clickElement(signInButton);
        return new AuthenticationPage(driver);
    }

    public ProductPage hoverOverAndClickPopularProduct(int index){
        Actions actions = new Actions(driver);
        WebElement hoverOverProduct = driver.findElements(popularProducts).get(index - 1);
        actions.moveToElement(hoverOverProduct).perform();
        actions.click().perform();
        return new ProductPage(driver);
    }

    public void clickSignOutButton(){
        driver.findElement(logoutButton).click();
    }

    public void clickElement(By locator){ driver.findElement(locator).click(); }

    public String getSignInButtonText(){ return driver.findElement(signInButton).getText(); }

}
