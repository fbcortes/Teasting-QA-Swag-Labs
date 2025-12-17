//Gestion de los elementos de la quinta página Checkout Complete.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {

    private WebDriver driver;

    public CheckoutComplete(WebDriver driver) {

        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By textComplete = By.xpath("/html/body/div/div/div/div[2]/h2");
    private By buttonBackHome = By.id("back-to-products");

    //Función para encontrar el mensaje de confirmación.
    public String getTextComplete() {
        return driver.findElement(textComplete).getText();
    }

    //Función para hacer click en el botón BackHome y volver a las Products Page.
    public ProductsPage backHome() {
        driver.findElement(buttonBackHome).click();
        return new ProductsPage(driver);
    }
}
