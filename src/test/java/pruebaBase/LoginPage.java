package pruebaBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
    By loginLocator = By.linkText("Iniciar sesión");
    By loginCondicion = By.tagName("h2");
    By emailLocator = By.id("user[email]");
    By passwordLocator = By.id("user[password]");
    By loginCheckBox = By.id("user[remember_me]");
    By loginBtnLocator = By.xpath("//*[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void signUser() throws InterruptedException {
        click(loginLocator);
        Thread.sleep(3000);
        if (isDisplayed(loginCondicion)) {
            type("matias@gmail.com", emailLocator);
            type("Luiza12345", passwordLocator);
            click(loginCheckBox);
            click(loginBtnLocator);
        } else {
            System.out.println("La pagina de registro no se encuentra disponible");
        }
    }

}
