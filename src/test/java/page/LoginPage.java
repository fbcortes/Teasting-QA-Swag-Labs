//Gestion de los elementos de la primera página Login.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginError = By.id("login_button_container");

    //Funciones para ingresar los input.
    public void sendUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void sendPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Función para obtener el texto de error del login.
    public String textLoginError() {
        return driver.findElement(loginError).getText();
    }

    //Hacer click en el login.
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    //Función para hacer login y saltar a la Products Page.
    public ProductsPage login(String username, String password) {
        sendUsername(username);
        sendPassword(password);
        clickLoginButton();

        return new ProductsPage(driver);
    }
}
