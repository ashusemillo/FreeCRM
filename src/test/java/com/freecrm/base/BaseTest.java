package com.freecrm.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public Properties prop;
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./config/config.properties");
            prop.load(fis);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("aut"));
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshots/" + testResult.getName() + ".png"));
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
