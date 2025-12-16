package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By slotCar1 = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By slotCar2 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]");
    private By slotCar3 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]");
    private By slotCar4 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[6]");
    private By slotCar5 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[7]");
    private By slotCar6 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[8]");
    private By bottonCheckout = By.id("checkout");

    public String textSlotCar1() {
        return driver.findElement(slotCar1).getText();
    }
}
