package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Waiter;

public class AuthenticationPage {

    private WebDriver driver;
    private Waiter waiter;
    private By emailLoginField = By.id("email");
    private By passwordLoginField = By.id("passwd");
    private By submitLoginButton = By.id("SubmitLogin");
    private By createAccountForm = By.id("noSlide");
    private By radioButtonContainer = By.cssSelector("div.account_creation div.clearfix");
    private By emailAddressField = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By radioButtonMr = By.id("//label[@for='id_gender1']");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By daysDropDown = By.id("days");
    private By monthsDropDown = By.id("months");
    private By yearsDropDown = By.id("years");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By cityField = By.id("city");
    private By stateDropDown = By.id("id_state");
    private By postalCodeField = By.id("postcode");
    private By countryDropDown = By.id("id_country");
    private By additionalInformationField = By.id("other");
    private By homePhoneField = By.id("phone");
    private By mobilePhoneField = By.id("phone_mobile");
    private By aliasAddressField = By.id("alias");
    private By registerButton = By.id("submitAccount");


    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
        waiter = new Waiter(driver);
    }

    public void setEmailAddressField(String email){
        driver.findElement(emailAddressField).sendKeys(email);
    }

    public void clickCreateAccountButton() throws InterruptedException {
        driver.findElement(createAccountButton).click();
    }

    public void waitForCreateAccountFormVisible(){
        //waiter.waitForElement(createAccountForm);
        WebElement accountForm = driver.findElement(createAccountForm);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style','visibility:visible')", accountForm);
    }

    public void clickRadioButtonMr(){
        driver.findElement(radioButtonMr).click();
    }

    public void setFirstNameField(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDaysDropDown(String day){
        Select dayElement = new Select(driver.findElement(daysDropDown));
        dayElement.selectByValue(day);
    }

    public void selectMonthsDropDown(String month){
        Select monthElement = new Select(driver.findElement(monthsDropDown));
        monthElement.selectByValue(month);
    }

    public void selectYearsDropDown(String year){
        Select yearElement = new Select(driver.findElement(yearsDropDown));
        yearElement.selectByValue(year);
    }

    public void setCompanyField(String company){
        driver.findElement(companyField).sendKeys(company);
    }

    public void setAddress1Field(String address1){
        driver.findElement(address1Field).sendKeys(address1);
    }

    public void setAddress2Field(String address2){
        driver.findElement(address2Field).sendKeys(address2);
    }

    public void setCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void selectStateDropDown(String state){
        Select stateElement = new Select(driver.findElement(stateDropDown));
        stateElement.selectByVisibleText(state);
    }

    public void setPostalCodeField(String postal){
        driver.findElement(postalCodeField).sendKeys(postal);
    }

    public void setAdditionalInformationField(String text){
        driver.findElement(additionalInformationField).sendKeys(text);
    }

    public void setHomePhoneField(String homePhone){
        driver.findElement(homePhoneField).sendKeys(homePhone);
    }

    public void setMobilePhoneField(String mobilePhone){
        driver.findElement(mobilePhoneField).sendKeys(mobilePhone);
    }

    public void setAliasAddressField(String alias){
        driver.findElement(aliasAddressField).clear();
        driver.findElement(aliasAddressField).sendKeys(alias);
    }

    public MyAccountPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }

    /**
     * Login methods
     */
    public void setEmailLoginField(String email){
        waiter.waitForElementPresent(emailAddressField);
        driver.findElement(emailLoginField).sendKeys(email);
    }

    public void setPasswordLoginField(String password){
        driver.findElement(passwordLoginField).sendKeys(password);
    }

    public MyAccountPage clickSubmitButton(){
        driver.findElement(submitLoginButton).click();
        return new MyAccountPage(driver);
    }

}
