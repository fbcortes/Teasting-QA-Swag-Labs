package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.LoginPage;
import page.ProductsPage;
import utils.Constants;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginStandard(){

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage.login(
                Constants.userStandard,
                Constants.password
        );

        String tituloEsperado = "Products";
        Assert.assertEquals(productsPage.textTitulo(), tituloEsperado,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");

        productsPage.clickButtonProduct1();

        CartPage cartPage = productsPage.irAlCarrito();

        Assert.assertEquals(productsPage.textNameProduct1(), cartPage.textSlotCar1(),
        "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");
    }
}