package com.endava.soa4;

import org.openqa.selenium.WebDriver;

//This class will ensure which browser we will run UI tests. Driver should be Singleton.
public abstract class DriverManager {
    protected WebDriver driver;

    protected void startService() {
    }

    protected abstract void stopService();

    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}
