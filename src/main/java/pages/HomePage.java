package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private int currentCartAmountOfProducts;
    private WebDriver driver;
    private By popularProducts = By.cssSelector("ul#homefeatured div.product-container");
    private By signOutButton = By.className("logout");
    //private By popularAddButtons = By.xpath("//ul[contains(@id, 'homefeatured')]/following::span[text()='Add to cart']");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public AuthenticationPage clickSignInButton(){
        clickElement(By.className("login"));
        return new AuthenticationPage(driver);
    }

    /*public void scrollToProducts(){
        WebElement firstPopularProductElement = driver.findElement(popularProducts);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, firstPopularProductElement);
    }*/

    public ProductPage hoverOverAndClickPopularProduct(int index){
        Actions actions = new Actions(driver);
        WebElement hoverOverProduct = driver.findElements(popularProducts).get(index - 1);
        actions.moveToElement(hoverOverProduct).perform();
        actions.click().perform();
        return new ProductPage(driver);
    }

    public void clickSignOutButton(){
        driver.findElement(signOutButton).click();
    }

    public void clickElement(By locator){ driver.findElement(locator).click(); }

}
