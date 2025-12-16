package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginError = By.id("login_button_container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ingresarUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }
    public void ingresarPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String textLoginError() {
        return driver.findElement(loginError).getText();
    }
    public ProductsPage login (String username, String password) {
        ingresarUsername(username);
        ingresarPassword(password);
        clickLoginButton();

        return new ProductsPage(driver);
    }
}
