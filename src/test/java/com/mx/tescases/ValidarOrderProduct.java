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

    public ValidarOrderProduct(){super();}

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        carPage = new CarPage();
        checkoutOnePage=new CheckoutOnePage();
        checkoutTwoPage=new CheckoutTwoPage();
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

    @Test
    public void validateProduct02(){
        checkoutOnePage = checkoutOnePage.enterUser(properties.getProperty("firstName"),
                properties.getProperty("lastName"), properties.getProperty("zipCode"));
        String name=inventoryPage.nameProduct.getText();
        String price=inventoryPage.priceProduct.getText();
       boolean flagOne =  checkoutTwoPage.validateProducto(name);
       Assert.assertTrue(flagOne);
       boolean flagTwo = checkoutTwoPage.validatePrecio(price);
       Assert.assertTrue(flagTwo);
    }

}
