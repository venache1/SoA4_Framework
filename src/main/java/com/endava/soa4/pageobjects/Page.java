package com.endava.soa4.pageobjects;

import com.endava.soa4.drivers.DriverManager;
import com.endava.soa4.drivers.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class Page {
    private WebDriver driver;
    {
        try {
            driver = DriverManager.getManager(DriverType.valueOf(getProperties("browser")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriverWait driverWait = new WebDriverWait(driver, 5);
}