package homepagetest;

import basetest.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.HomeFactory;
import pagefactory.LoginFactory;

import java.util.concurrent.TimeUnit;

public class PageFactoryTest {

    private WebDriver driver;

    @BeforeEach
    public void setUpFactory(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown(){ driver.quit(); }

    @Test
    public void loginFacTest(){
        HomeFactory homeFactory = PageFactory.initElements(driver, HomeFactory.class);
        LoginFactory loginFactory = PageFactory.initElements(driver, LoginFactory.class);

        homeFactory.clickLoginButton();
        loginFactory.setEmail("testfactory2133@example.com");
        loginFactory.clickCreateButton();
    }


}
