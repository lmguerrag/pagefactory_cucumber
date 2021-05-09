package homepagetest;

import basetest.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChallenge extends BaseTest {

    @Test
    public void addToCartTest(){
       ProductPage productPage = homePage.hoverOverAndClickPopularProduct(4);
       productPage.clickAddToCartButton();
       CartPage cartPage = productPage.clickProceedToCheckout();
       assertEquals("SKU : demo_4", cartPage.getProductReference());
    }

    //Se debe cambiar el email en el csv file para registrar un nuevo usuario, puesto que
    //ya se encuentra registrado el actual
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/create_new_account.csv", numLinesToSkip = 1)
    public void createNewAccountTest(String email, String firstName, String lastName, String password,
                                     String day, String month, String year, String company, String address1,
                                     String address2, String city, String state, String postalCode,
                                     String info, String homePhone, String mobilePhone, String alias) {
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.setEmailAddressField(email);
        authenticationPage.clickCreateAccountButton();
        authenticationPage.setFirstNameField(firstName);
        authenticationPage.setLastNameField(lastName);
        authenticationPage.setPasswordField(password);
        authenticationPage.selectDaysDropDown(day);
        authenticationPage.selectMonthsDropDown(month);
        authenticationPage.selectYearsDropDown(year);
        authenticationPage.setCompanyField(company);
        authenticationPage.setAddress1Field(address1);
        authenticationPage.setAddress2Field(address2);
        authenticationPage.setCityField(city);
        authenticationPage.selectStateDropDown(state);
        authenticationPage.setPostalCodeField(postalCode);
        authenticationPage.setAdditionalInformationField(info);
        authenticationPage.setHomePhoneField(homePhone);
        authenticationPage.setMobilePhoneField(mobilePhone);
        authenticationPage.setAliasAddressField(alias);
        MyAccountPage myAccountPage = authenticationPage.clickRegisterButton();
        assertEquals("Welcome to your account. Here you can manage all of your personal " +
                "information and orders.", myAccountPage.getAccountLoginMessage());

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/login.csv", numLinesToSkip = 1)
    public void loginTest(String email, String password){
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.setEmailLoginField(email);
        authenticationPage.setPasswordLoginField(password);
        MyAccountPage myAccountPage = authenticationPage.clickSubmitButton();
        assertEquals("Welcome to your account. Here you can manage all of your personal " +
                "information and orders.", myAccountPage.getAccountLoginMessage());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/login.csv", numLinesToSkip = 1)
    public void signOutFromHomeTest(String email, String password){
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.setEmailLoginField(email);
        authenticationPage.setPasswordLoginField(password);
        MyAccountPage myAccountPage = authenticationPage.clickSubmitButton();
        myAccountPage.clickHomePageButton();
        homePage.clickSignOutButton();
        assertEquals("Sign in", homePage.getSignInButtonText());
    }

    @Test
    public void buyProductTest(){
        ProductPage productPage = homePage.hoverOverAndClickPopularProduct(4);
        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.clickProceedToCheckout();
        SignInStepPage signInStepPage = cartPage.clickProceedButtonWithLogin();
        signInStepPage.setEmailCartField();
        signInStepPage.setPasswordCartField();
        AddressStepPage addressStepPage = signInStepPage.clickSignButton();
        ShippingStepPage shippingStepPage = addressStepPage.clickProceedButtonOnAddressStep();
        shippingStepPage.clickTermsOfServiceCheckbox();
        PaymentStepPage paymentPage = shippingStepPage.clickProceedOnShippingStep();
        SummaryStepPage summaryStepPage = paymentPage.clickBankWire();
        OrderConfirmationPage orderConfirmationPage = summaryStepPage.clickConfirmOrderButton();
        assertEquals("Your order on My Store is complete.",
                orderConfirmationPage.getConfirmationMessage());

    }

}
