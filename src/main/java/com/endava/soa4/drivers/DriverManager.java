package com.endava.soa4.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getManager(DriverType type) {
        switch (type) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new RuntimeException("Unexpected browser type: " + type);
        }
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            try {
                options.setHeadless(Boolean.parseBoolean(getProperties("headless")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
            try {
                options.setHeadless(Boolean.parseBoolean(getProperties("headless")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.setProperty("webdriver.ghecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
