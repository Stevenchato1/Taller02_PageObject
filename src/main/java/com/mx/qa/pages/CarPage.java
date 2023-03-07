package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarPage extends TestBase {
    @FindBy(xpath = "//a[contains(@class,inventory_item)]//div[contains(text(),'Backpack')]")
    public WebElement validateName;

    @FindBy(xpath = "(//div[contains(@class,'pricebar')])[position()=1]")
    public WebElement validatePrice;

    @FindBy(id = "checkout")
    public WebElement btnCheckout;

    InventoryPage item = new InventoryPage();
    String name = item.name_Product;
    String price = item.price_Product;

    public CarPage() {
        PageFactory.initElements(driver, this);
    }
    public boolean validateProducto() {
        return validateName.getText().equals(name);
    }

    public boolean validatePrecio() {
        return validatePrice.getText().equals(price);
    }

    public void irCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckout);
    }


}
