//Test 4 simula una orden de compra completa.
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import utils.Constants;

public class E2ETest extends BaseTest {

    @Test
    public void testE2E() {

        LoginPage loginPage = new LoginPage(driver);

        //Ejecutamos la función Login.
        ProductsPage productsPage = loginPage.login(
                Constants.userStandard,
                Constants.password
        );

        //Verificamos que hayamos ingresado a la Products Page.
        String tituloEsperado = "Products";
        Assert.assertEquals(productsPage.textTitulo(), tituloEsperado,
                "La aserción fallo: el titulo esperando no coincide con el titulo obtenido");

        //Seleccionamos todos los productos disponibles.
        productsPage.clickButtonProduct1();
        productsPage.clickButtonProduct2();
        productsPage.clickButtonProduct3();
        productsPage.clickButtonProduct4();
        productsPage.clickButtonProduct5();
        productsPage.clickButtonProduct6();

        //Seleccionamos el carrito.
        CartPage cartPage = productsPage.irAlCarrito();

        //Verificamos que los productos seleccionados coincidan con los productos en el Cart Page.
        Assert.assertEquals(productsPage.textNameProduct1(), cartPage.textSlotCar1(),
                "La aserción fallo: el titulo del producto 1 no coincide");
        Assert.assertEquals(productsPage.textNameProduct2(), cartPage.textSlotCar2(),
                "La aserción fallo: el titulo del producto 2 no coincide");
        Assert.assertEquals(productsPage.textNameProduct3(), cartPage.textSlotCar3(),
                "La aserción fallo: el titulo del producto 3 no coincide");
        Assert.assertEquals(productsPage.textNameProduct4(), cartPage.textSlotCar4(),
                "La aserción fallo: el titulo del producto 4 no coincide");
        Assert.assertEquals(productsPage.textNameProduct5(), cartPage.textSlotCar5(),
                "La aserción fallo: el titulo del producto 5 no coincide");
        Assert.assertEquals(productsPage.textNameProduct6(), cartPage.textSlotCar6(),
                "La aserción fallo: el titulo del producto 6 no coincide");

        //Le damos al botón Checkout.
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        //Rellenamos los datos del formulario y enviamos el formulario.
        CheckoutPageTwo checkoutPageTwo = checkoutPage.sendForm(
                Constants.firstname,
                Constants.lastname,
                Constants.postalcode
        );

        //Validamos que los productos en el Checkout Page, sean los mismos que en el Cart Page.
        Assert.assertEquals(cartPage.textSlotCar1(), checkoutPageTwo.textSlotCar1(),
                "La aserción fallo: el titulo del producto 1 no coincide");
        Assert.assertEquals(cartPage.textSlotCar2(), checkoutPageTwo.textSlotCar2(),
                "La aserción fallo: el titulo del producto 2 no coincide");
        Assert.assertEquals(cartPage.textSlotCar3(), checkoutPageTwo.textSlotCar3(),
                "La aserción fallo: el titulo del producto 3 no coincide");
        Assert.assertEquals(cartPage.textSlotCar4(), checkoutPageTwo.textSlotCar4(),
                "La aserción fallo: el titulo del producto 4 no coincide");
        Assert.assertEquals(cartPage.textSlotCar5(), checkoutPageTwo.textSlotCar5(),
                "La aserción fallo: el titulo del producto 5 no coincide");
        Assert.assertEquals(cartPage.textSlotCar6(), checkoutPageTwo.textSlotCar6(),
                "La aserción fallo: el titulo del producto 6 no coincide");

        //Confirmamos la compra.
        CheckoutComplete checkoutComplete = checkoutPageTwo.clickButtonFinish();

        //Validamos el mensaje de confirmación.
        String titleFinal = "Thank you for your order!";
        Assert.assertEquals(checkoutComplete.getTextComplete(), titleFinal,
                "La aserción fallo: el titulo final no coincide con el titulo esperado");

        //Volvemos a la Products Page.
        checkoutComplete.backHome();
    }
}