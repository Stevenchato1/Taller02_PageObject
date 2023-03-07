package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage extends TestBase {
    public CheckoutFinishPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement message;

    public boolean validateFinish() {
        return message.getText().contains("Thank you for your order!");
    }
}
