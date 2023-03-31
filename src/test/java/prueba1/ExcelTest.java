package prueba1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import ExcelFile.ReadExcelFile;
import ExcelFile.WriteExcelFile;

import java.io.IOException;

import org.junit.*;

public class ExcelTest {
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;
    private By serchBoxLocator = By.tagName("input");

    // driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);

    @Before
    public void setUp() throws Exception {
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\Users\\matia\\OneDrive\\Escritorio\\chromedriver.exe");
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver(chromeOptions);
        // writeFile = new WriteExcelFile();
        // readFile = new ReadExcelFile();

        // driver.get("https://www.happyfamily.cl/pages/Academia");

    }

    @Test
    public void test() throws IOException, InterruptedException {
        WebDriver driver = SuiteTest.driver;
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();
        Thread.sleep(6000);
        String filePath = ".\\src\\test\\resources\\excelAProbar.xlsx";
        String searchText = readFile.getCellValue(filePath, "Hoja1", 0, 0);
        WebElement serchBox = driver.findElement(serchBoxLocator);
        serchBox.sendKeys(searchText, Keys.ENTER);

        String x = "Encontrado";
        readFile.readExcel(filePath, "Hoja1");
        writeFile.writeCellValue(filePath, "Hoja1", 0, 1, x);
        readFile.readExcel(filePath, "Hoja1");

    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

}
