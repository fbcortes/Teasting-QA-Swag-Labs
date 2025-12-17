//Gestion de los elementos de la quinta página Checkout Two.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPageTwo {

    private WebDriver driver;

    public CheckoutPageTwo(WebDriver driver) {
        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By slot1 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div");
    private By slot2 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div");
    private By slot3 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[5]/div[2]/a/div");
    private By slot4 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[6]/div[2]/a/div");
    private By slot5 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[7]/div[2]/a/div");
    private By slot6 = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[8]/div[2]/a/div");
    private By finishButton = By.id("finish");

    //Función para hacer scroll y encontrar los elementos de la página.
    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Funciones que me permiten obtener texto de los elementos de la página.
    public String textSlotCar1() {
        return driver.findElement(slot1).getText();
    }

    public String textSlotCar2() {
        return driver.findElement(slot2).getText();
    }

    public String textSlotCar3() {
        return driver.findElement(slot3).getText();
    }

    public String textSlotCar4() {
        return driver.findElement(slot4).getText();
    }

    public String textSlotCar5() {
        scrollToElement(slot5);
        return driver.findElement(slot5).getText();
    }

    public String textSlotCar6() {
        scrollToElement(slot6);
        return driver.findElement(slot6).getText();
    }

    //Función para encontrar el botón y pasar a la última página Checkout Complete Page.
    public CheckoutComplete clickButtonFinish() {
        scrollToElement(finishButton);
        driver.findElement(finishButton).click();
        return new CheckoutComplete(driver);
    }
}