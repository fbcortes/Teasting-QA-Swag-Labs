//Test 1 que busca hacer un login exitoso con credenciales de un usuario standard.
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
    public void testLoginStandard() {

        LoginPage loginPage = new LoginPage(driver);
        //Ejecuta la función de login.
        ProductsPage productsPage = loginPage.login(
                Constants.userStandard,
                Constants.password
        );
        //Validación que hemos ingresado a la Products Page.
        //Compara el título de la página con un título indicado.
        String tituloEsperado = "Products";
        Assert.assertEquals(productsPage.textTitulo(), tituloEsperado,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");
        //Selecciona el primer producto.
        productsPage.clickButtonProduct1();

        //Selecciona el carro de compras.
        CartPage cartPage = productsPage.irAlCarrito();

        //Validación del nombre del producto coincida con el título del producto en el carrito.
        Assert.assertEquals(productsPage.textNameProduct1(), cartPage.textSlotCar1(),
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");
    }
}