//Gestion de los elementos de la cuarta página Checkout.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    //Funciones para ingresar los input.
    public void sendFirstName(String firstNameInput) {
        driver.findElement(firstName).sendKeys(firstNameInput);
    }

    public void sendLastName(String lastNameInput) {
        driver.findElement(lastName).sendKeys(lastNameInput);
    }

    public void sendPostalCode(String postalCodeInput) {
        driver.findElement(postalCode).sendKeys(postalCodeInput);
    }

    //Hacer click en el Continue.
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    //Función para enviar el formulario y saltar a la Checkout Two Page.
    public CheckoutPageTwo sendForm(String firstNameInput, String lastNameInput, String postalCodeInput) {
        sendFirstName(firstNameInput);
        sendLastName(lastNameInput);
        sendPostalCode(postalCodeInput);
        clickContinue();
        return new CheckoutPageTwo(driver);
    }
}
