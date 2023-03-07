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

;

    public boolean validateProducto(String name) {
        return nameProduct.getText().equals(name);
    }

    public boolean validatePrecio(String price) {
        String precio=priceProduct.getText();
        return price.contains(precio);
    }

    public void enterFinish() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", finish);
    }
}
