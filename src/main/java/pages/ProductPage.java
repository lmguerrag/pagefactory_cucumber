package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiter;

public class ProductPage {

    private Waiter waiter;
    private WebDriver driver;
    private By primaryBlock = By.className("primary_block ");
    private By addToCartButton = By.cssSelector("button.exclusive");
    private By layerCart = By.id("layer_cart");
    private By proceedCheckoutButton = By.xpath("//a[@class='btn btn-default button button-medium']");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        waiter = new Waiter(driver);
    }

    public void clickAddToCartButton(){
        waiter.waitForElementPresent(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickProceedToCheckout(){
        waiter.waitForElementVisible(layerCart);
        driver.findElement(proceedCheckoutButton).click();
        return new CartPage(driver);
    }

}
