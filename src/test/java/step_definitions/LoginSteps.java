package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.HomeFactory;
import pagefactory.LoginFactory;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private WebDriver driver;
    private LoginFactory loginFactory;
    private HomeFactory homeFactory;

    @Given("que soy un cliente")
    public void que_soy_un_cliente() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginFactory = new LoginFactory(driver);
        homeFactory = new HomeFactory(driver);

    }
    @When("cuando ingrese mis credenciales correctamente")
    public void cuando_ingrese_mis_credenciales_correctamente() {
        //HomeFactory homeFactory = PageFactory.initElements(driver, HomeFactory.class);
        //LoginFactory loginFactory = PageFactory.initElements(driver, LoginFactory.class);

        homeFactory.clickLoginButton();
        loginFactory.setEmail("testfactory2133@example.com");
        loginFactory.clickCreateButton();

    }
    @Then("inicio sesion")
    public void inicio_sesion() {
        assertEquals("YOUR PERSONAL INFORMATION", loginFactory.getMessage());
    }
}
