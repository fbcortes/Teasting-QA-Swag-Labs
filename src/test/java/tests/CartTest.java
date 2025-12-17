//Test 3 que busca hacer un login exitoso, ordenar los productos del precio más alto al más bajo, y comprobar el orden.
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

        //Ejecuta la función de login.
        ProductsPage productsPage = loginPage.login(
                Constants.userStandard,
                Constants.password
        );
        //Verifica que haya ingresado a la Products Page.
        String tituloEsperado = "Products";
        Assert.assertEquals(productsPage.textTitulo(), tituloEsperado,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");

        //Ordena los productos del más caro al más bajo.
        productsPage.clickButtonOrderH2L();

        //Validamos que el primer producto sea más alto que el último producto.
        Assert.assertTrue(productsPage.priceDoubleProduct1() > productsPage.priceDoubleProduct6(), "falla todo");
    }
}