package com.mx.qa.pages;

import com.mx.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "user-name")
    public WebElement users;

    @FindBy(id = "password" )
    public WebElement passwords;

    @FindBy(id = "login-button")
    public WebElement login;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterLogin(String user, String password){
        users.sendKeys(user);
        passwords.sendKeys(password);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", login);
        return new LoginPage();
    }

}
