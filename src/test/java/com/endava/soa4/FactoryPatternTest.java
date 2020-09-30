package com.endava.soa4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class FactoryPatternTest {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driverManager = DriverManagerFactory.getManager(DriverType.valueOf(getProperties("browser")));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchAutomationTest() throws IOException {
        driver.get(getProperties("homeUrl"));
        Assert.assertEquals(getProperties("pageTitle"),driver.findElement(By.xpath("//h1[contains(text(),'Automation Practice Website')]")).getText());
    }

}
