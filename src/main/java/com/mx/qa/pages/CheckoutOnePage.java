package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends TestBase {
    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipCode;

    @FindBy(id ="continue")
    public  WebElement btnContinue;

    public CheckoutOnePage() {
        PageFactory.initElements(driver, this);
    }

    public CarPage enterUser(String name, String last, String code){
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        zipCode.sendKeys(code);
        return new CarPage();
    }

    public void irCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnContinue);
    }



}
