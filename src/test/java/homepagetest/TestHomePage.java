package homepagetest;

import basetest.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestHomePage extends BaseTest {

    @Test
    public void addToCartTest(){
       ProductPage productPage = homePage.hoverOverAndClickPopularProduct(4);
       productPage.clickAddToCartButton();
       CartPage cartPage = productPage.clickProceedToCheckout();
       assertEquals("SKU : demo_4", cartPage.getProductReference());
    }

    @Test
    public void createNewAccountTest() throws InterruptedException {
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        Thread.sleep(3000);
        authenticationPage.setEmailAddressField("qeqwsdf@example.com");
        authenticationPage.clickCreateAccountButton();
        Thread.sleep(3000);
        authenticationPage.setFirstNameField("Luis");
        authenticationPage.setLastNameField("Guerra");
        authenticationPage.setPasswordField("123456");
        authenticationPage.selectDaysDropDown("24");
        authenticationPage.selectMonthsDropDown("11");
        authenticationPage.selectYearsDropDown("1994");
        authenticationPage.setCompanyField("Sofka");
        authenticationPage.setAddress1Field("calle 1");
        authenticationPage.setAddress2Field("calle 2");
        authenticationPage.setCityField("cartagena");
        authenticationPage.selectStateDropDown("Colorado");
        authenticationPage.setPostalCodeField("00000");
        authenticationPage.setAdditionalInformationField("white house with huge garden");
        authenticationPage.setHomePhoneField("555555");
        authenticationPage.setMobilePhoneField("777777");
        authenticationPage.setAliasAddressField("adrees 1");
        MyAccountPage myAccountPage = authenticationPage.clickRegisterButton();
        assertEquals("Welcome to your account. Here you can manage all of your personal " +
                "information and orders.", myAccountPage.getAccountLoginMessage());
    }

    /*@Test
    public void signOutTest(){
        homePage.clickSignOutButton();
    }*/

    @Test
    public void loginTest(){
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        authenticationPage.setEmailLoginField("luis@example.com");
        authenticationPage.setPasswordLoginField("123456");
        MyAccountPage myAccountPage = authenticationPage.clickSubmitButton();
        assertEquals("Welcome to your account. Here you can manage all of your personal " +
                "information and orders.", myAccountPage.getAccountLoginMessage());
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
        assertEquals("Your order on My Store is complete.", orderConfirmationPage.getConfirmationMessage());

    }

}
