package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CarPage extends TestBase {
    public CarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,inventory_item)]//div[contains(text(),'Backpack')]")
    public WebElement validateName;

    @FindBy(xpath = "(//div[contains(@class,'inventory_item_price')])[position()=1]")
    public WebElement validatePrice;

    @FindBy(id = "checkout")
    public WebElement btnCheckout;



    public boolean validateProducto(String name) {
        return validateName.getText().equals(name);
    }

    public boolean validatePrecio(String price) {
        String precio=validatePrice.getText();
        return price.contains(precio);

    }

    public void irCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckout);
    }


}
