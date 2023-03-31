package prueba1;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Suite.class)
@SuiteClasses({
        LoginTest.class,
        // ExcelTest.class,
        DropdownList.class,
// OpenAllTabsAndExports.class
})

public class SuiteTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matia\\OneDrive\\Escritorio\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.happyfamily.cl/pages/Academia");
    }

    @AfterClass
    public static void setDownClass() {
        // driver.quit();
    }
}
