package prueba1;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pruebaBase.RegisterPage;

public class RegisterTest {

    private WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void setUp() throws Exception {
        registerPage = new RegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("https://www.happyfamily.cl/pages/Academia");

    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    // Verificación de registro
    @Test
    public void test() throws InterruptedException {
        registerPage.registerUser();
    }

}
