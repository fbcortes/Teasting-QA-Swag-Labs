//Gestion de los elementos de la segunda página Products.
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Declaración de elementos iniciales.
    private By title = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By cartButton = By.id("shopping_cart_container");
    private By nameProduct1 = By.id("item_4_title_link");
    private By nameProduct2 = By.id("item_0_title_link");
    private By nameProduct3 = By.id("item_1_title_link");
    private By nameProduct4 = By.id("item_5_title_link");
    private By nameProduct5 = By.id("item_2_title_link");
    private By nameProduct6 = By.id("item_3_title_link");
    private By product1Button = By.id("add-to-cart-sauce-labs-backpack");
    private By product2Button = By.id("add-to-cart-sauce-labs-bike-light");
    private By product3Button = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By product4Button = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By product5Button = By.id("add-to-cart-sauce-labs-onesie");
    private By product6Button = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By orderButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    private By orderH2LButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");
    private By product1Price = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By product6Price = By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div");

    //Función para hacer scroll y encontrar los elementos de la página.
    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Funciones que me permiten obtener texto de los elementos de la página.
    public String textTitulo() {
        return driver.findElement(title).getText();
    }

    public String textNameProduct1() {
        return driver.findElement(nameProduct1).getText();
    }

    public String textNameProduct2() {
        return driver.findElement(nameProduct2).getText();
    }

    public String textNameProduct3() {
        return driver.findElement(nameProduct3).getText();
    }

    public String textNameProduct4() {
        return driver.findElement(nameProduct4).getText();
    }

    public String textNameProduct5() {
        return driver.findElement(nameProduct5).getText();
    }

    public String textNameProduct6() {
        return driver.findElement(nameProduct6).getText();
    }

    public Double priceDoubleProduct1() {
        String priceText = driver.findElement(product1Price).getText();
        String cleanPrice = priceText.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }

    public Double priceDoubleProduct6() {
        String priceText = driver.findElement(product6Price).getText();
        String cleanPrice = priceText.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }

    //Función para hacer click en los botones de la página.
    public void clickButtonProduct1() {
        driver.findElement(product1Button).click();
    }

    public void clickButtonProduct2() {
        driver.findElement(product2Button).click();
    }

    public void clickButtonProduct3() {
        driver.findElement(product3Button).click();
    }

    public void clickButtonProduct4() {
        driver.findElement(product4Button).click();
    }

    public void clickButtonProduct5() {
        scrollToElement(product5Button);
        driver.findElement(product5Button).click();
    }

    public void clickButtonProduct6() {
        scrollToElement(product6Button);
        driver.findElement(product6Button).click();
    }

    public void clickButtonOrderH2L() {
        driver.findElement(orderButton).click();
        driver.findElement(orderH2LButton).click();
    }

    //Salto a la siguiente a la Cart Page
    public CartPage irAlCarrito() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}