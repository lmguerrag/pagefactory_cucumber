package basetest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    @AfterAll
    public void tearDown(){ driver.quit(); }
}
