package prueba1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownList {

    @Test
    public void selectDropdownList() throws InterruptedException {
        WebDriver driver = SuiteTest.driver;

        Thread.sleep(8000);
        WebElement dropdownListBtn = driver.findElement(By.cssSelector("button[data-toggle='dropdown']"));
        dropdownListBtn.click();

        Thread.sleep(6000);

        WebElement option2 = driver.findElement(By.linkText("Mi Cuenta"));
        option2.click();

    }

}
