package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage extends TestBase {

    public CheckoutTwoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,inventory_item)]//div[contains(text(),'Backpack')]")
    public WebElement nameProduct;

    @FindBy(xpath = "(//div[contains(@class,'pricebar')])[position()=1]")
    public WebElement priceProduct;

    @FindBy(id="finish")
    public WebElement finish;

    InventoryPage item = new InventoryPage();
    String name = item.name_Product;
    String price = item.price_Product;

    public boolean validateProducto() {
        return nameProduct.getText().equals(name);
    }

    public boolean validatePrecio() {
        return priceProduct.getText().equals(price);
    }

    public void enterFinish() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", finish);
    }
}
