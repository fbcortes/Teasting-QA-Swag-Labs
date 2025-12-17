//Gestion de los elementos de la tercera página Cart.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By slotCar1 = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By slotCar2 = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private By slotCar3 = By.xpath("//*[@id=\"item_1_title_link\"]/div");
    private By slotCar4 = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private By slotCar5 = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    private By slotCar6 = By.xpath("//*[@id=\"item_3_title_link\"]/div");
    private By checkoutButton = By.id("checkout");

    //Función para hacer scroll y encontrar los elementos de la página.
    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Funciones que me permiten obtener texto de los elementos de la página.
    public String textSlotCar1() {
        return driver.findElement(slotCar1).getText();
    }

    public String textSlotCar2() {
        return driver.findElement(slotCar2).getText();
    }

    public String textSlotCar3() {
        return driver.findElement(slotCar3).getText();
    }

    public String textSlotCar4() {
        return driver.findElement(slotCar4).getText();
    }

    public String textSlotCar5() {
        return driver.findElement(slotCar5).getText();
    }

    public String textSlotCar6() {
        return driver.findElement(slotCar6).getText();
    }

    //Salto a la siguiente a la Checkout Page
    public CheckoutPage goToCheckout() {
        scrollToElement(checkoutButton);
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
