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

        ProductsPage productsPage = loginPage.login(
                Constants.userInvalid,
                Constants.password
        );

        String tituloEsperadoError = "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(loginPage.textLoginError(), tituloEsperadoError,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");
    }
}
