package prueba1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matia\\OneDrive\\Escritorio\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

    }

    @Test
    public void testGooglePage() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("ACL");
        Thread.sleep(10000);
        searchBox.submit();
        Thread.sleep(10000);
        assertEquals("ACL - Buscar con Google", driver.getTitle());

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

// localizadores
// By locator = By.id("id");
// by locator_name = By.name("name");
// by locator_class = By.className("class");
// by locator_tag = By.tagName("tag");
// by locator_link = By.linkText("texto_link");
// by locator_partial_link = By.partialLinkText("parte_texto_link");
// by locator_css = By.cssSelector("css");
// by locator_xpath = By.xpath("xpath");

// js
// JavascriptExecutor js = (JavascriptExecutor) driver;
// js.executeScript("window.scrollBy(0,1000)");