//Test 2 que busca hacer un login fallido con credenciales de un usuario inválido.
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;
import utils.Constants;

public class LoginTestFailed extends BaseTest {

    @Test
    public void testLoginInvalid() {

        LoginPage loginPage = new LoginPage(driver);

        //Ejecuta la función de login.
        ProductsPage productsPage = loginPage.login(
                Constants.userInvalid,
                Constants.password
        );

        //Validación que hemos ingresado el usuario inválido y se identifique el mensaje erróneo.
        String tituloEsperadoError = "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(loginPage.textLoginError(), tituloEsperadoError,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");
    }
}
