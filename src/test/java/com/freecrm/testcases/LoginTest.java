package com.freecrm.testcases;

import com.freecrm.base.BaseTest;
import com.freecrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
    @Test
    public void loginToApp() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.navigateToLoginPage();
        lp.enterUsrName(prop.getProperty("username"));
        lp.enterPwd(prop.getProperty("password"));
        lp.clickLoginBtn();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
    }

}
