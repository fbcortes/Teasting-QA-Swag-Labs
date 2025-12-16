package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;
import utils.Constants;

public class CartTest extends BaseTest {

    @Test
    public void testLoginStandard() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage.login(
                Constants.userStandard,
                Constants.password
        );

        String tituloEsperado = "Products";
        Assert.assertEquals(productsPage.textTitulo(), tituloEsperado,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");

        productsPage.clickButtonOrderH2L();

        Assert.assertTrue(productsPage.priceDoubleProduct1() > productsPage.priceDoubleProduct6(), "falla todo");
    }
}