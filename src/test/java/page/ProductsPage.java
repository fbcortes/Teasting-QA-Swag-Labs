package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titulo = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By carrito = By.id("shopping_cart_container");
    private By nameProduct1 = By.id("item_4_title_link");
    private By nameProduct2 = By.id("item_0_title_link");
    private By nameProduct3 = By.id("item_1_title_link");
    private By nameProduct4 = By.id("item_5_title_link");
    private By nameProduct5 = By.id("item_2_title_link");
    private By nameProduct6 = By.id("item_3_title_link");
    private By buttonProduct1 = By.id("add-to-cart-sauce-labs-backpack");
    private By buttonProduct2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By buttonProduct3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By buttonProduct4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By buttonProduct5 = By.id("add-to-cart-sauce-labs-onesie");
    private By buttonProduct6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By buttonOrder = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    private By buttonOrderH2L = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");
    private By priceProduct1 = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By priceProduct6 = By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div");

    public String textTitulo() {
        return driver.findElement(titulo).getText();
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
        String priceText = driver.findElement(priceProduct1).getText();
        String cleanPrice = priceText.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }
    public Double priceDoubleProduct6() {
        String priceText = driver.findElement(priceProduct6).getText();
        String cleanPrice = priceText.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }
    public void clickButtonProduct1() {
        driver.findElement(buttonProduct1).click();
    }
    public void clickButtonProduct2() {
        driver.findElement(buttonProduct2).click();
    }
    public void clickButtonProduct3() {
        driver.findElement(buttonProduct3).click();
    }
    public void clickButtonProduct4() {
        driver.findElement(buttonProduct4).click();
    }
    public void clickButtonProduct5() {
        driver.findElement(buttonProduct5).click();
    }
    public void clickButtonProduct6() {
        driver.findElement(buttonProduct6).click();
    }
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }
    public void clickButtonOrderH2L() {
        driver.findElement(buttonOrder).click();
        driver.findElement(buttonOrderH2L).click();
    }
// salto a la siguiente Page
    public CartPage irAlCarrito() {
        driver.findElement(carrito).click();
        return new CartPage(driver);
    }
}