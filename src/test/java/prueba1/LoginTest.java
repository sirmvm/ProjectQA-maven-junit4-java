package prueba1;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pruebaBase.LoginPage;

public class LoginTest {

    // private WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        // loginPage = new LoginPage(driver);
        // driver = loginPage.chromeDriverConnection();
        // loginPage.visit("https://www.happyfamily.cl/pages/Academia");

    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    @Test
    public void loginUser() throws InterruptedException {
        WebDriver driver = SuiteTest.driver;
        loginPage = new LoginPage(driver);
        loginPage.signUser();

    }

}
