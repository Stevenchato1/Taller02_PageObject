package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends TestBase {
    @FindBy(xpath = "//div[@class='checkout_info']//input[@id='first-name']")
    public WebElement firstName;

    @FindBy(id = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy(id = "//input[@id='postal-code']")
    public WebElement zipCode;

    @FindBy(id ="continue")
    public  WebElement btnContinue;

    public CheckoutOnePage() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutOnePage enterUsuari(String user){
        firstName.click();
        firstName.sendKeys(user);
        return new  CheckoutOnePage();
    }



}
