package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends TestBase {
    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id ="continue")
    public  WebElement btnContinue;

    public CheckoutOnePage() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutOnePage enterUser(String firstname, String lastname, String zipcode) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        zipCode.sendKeys(zipcode);
        return new CheckoutOnePage();
    }


}
