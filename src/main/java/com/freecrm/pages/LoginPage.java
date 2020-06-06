package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    @CacheLookup
    WebElement logIn;
    @FindBy(name = "email")
    @CacheLookup
    WebElement emailTxt;
    @FindBy(name = "password")
    @CacheLookup
    WebElement pwdTxt;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    @CacheLookup
    WebElement loginBtn;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void navigateToLoginPage() {
        logIn.click();
    }

    public void enterUsrName(String uname) {
        emailTxt.sendKeys(uname);
    }

    public void enterPwd(String pwd) {
        pwdTxt.sendKeys(pwd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }
}
