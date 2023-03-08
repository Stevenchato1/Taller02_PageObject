package com.mx.tescases;

import com.mx.qa.base.TestBase;
import com.mx.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidarOrderProduct extends TestBase {
    /*CarPage,checkoutTwo*/
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CarPage carPage;
    CheckoutOnePage checkoutOnePage;
    CheckoutTwoPage checkoutTwoPage;
    CheckoutFinishPage checkoutFinishPage;

    public ValidarOrderProduct(){super();}

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        carPage = new CarPage();
        checkoutOnePage=new CheckoutOnePage();
        checkoutTwoPage=new CheckoutTwoPage();
        checkoutFinishPage=new CheckoutFinishPage();
    }

    @Test
    public void validateProductinOrder(){
        loginPage.enterLogin("standard_user","secret_sauce");
        String name=inventoryPage.nameProduct.getText();
        String price=inventoryPage.priceProduct.getText();
        inventoryPage.agregarCarrito();
        inventoryPage.irCarrito();
        boolean flagTrue1 = carPage.validateProducto(name);
        Assert.assertTrue(flagTrue1);

        boolean flagTrue2 = carPage.validatePrecio(price);
        Assert.assertTrue(flagTrue2);
        carPage.irCheckout();

        checkoutOnePage.enterUser(properties.getProperty("firstName"), properties.getProperty("lastName"),
                properties.getProperty("zipCode"));
        checkoutOnePage.irCheckout();
       boolean flagTrue3 =checkoutTwoPage.validateProducto(name);
       Assert.assertTrue(flagTrue3);

       boolean flagTrue4 =  checkoutTwoPage.validatePrecio(price);
       Assert.assertTrue(flagTrue4);
        checkoutTwoPage.enterFinish();

        boolean flagTrue5=checkoutFinishPage.validateFinish();
        Assert.assertTrue(flagTrue5);


    }








}
