package com.mx.tescases;

import com.mx.qa.base.TestBase;
import com.mx.qa.pages.CarPage;
import com.mx.qa.pages.InventoryPage;
import com.mx.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidarOrderProduct extends TestBase {
    /*CarPage,checkoutTwo*/
    LoginPage loginPage;
    InventoryPage inventoryPage;

    CarPage carPage;

    public ValidarOrderProduct(){super();}

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        carPage = new CarPage();
    }

    @Test
    public void validateProduct(){
        loginPage.enterLogin("standard_user","secret_sauce");
        String name=inventoryPage.nameProduct.getText();
        String price=inventoryPage.priceProduct.getText();
        inventoryPage.agregarCarrito();
        inventoryPage.irCarrito();
        boolean flagTrue = carPage.validateProducto(name);
        Assert.assertTrue(flagTrue);

        boolean flagPrice = carPage.validatePrecio(price);
        Assert.assertTrue(flagPrice);
        carPage.irCheckout();

    }

}
