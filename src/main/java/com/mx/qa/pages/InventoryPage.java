package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends TestBase {
    @FindBy(xpath = "//a[contains(@class,inventory_item)]//div[contains(text(),'Backpack')]")
    public WebElement nameProduct;

    @FindBy(xpath = "(//div[contains(@class,'pricebar')])[position()=1]")
    public WebElement priceProduct;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement btnCar;



    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    public void agregarCarrito() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addCart);
    }

    public void irCarrito() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCar);
    }




}
