package com.endava.soa4.stepdefs;

import com.endava.soa4.drivers.DriverManager;
import com.endava.soa4.drivers.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class Hooks {
    WebDriver driver;

    public Hooks() {
        try {
            driver = DriverManager.getManager(DriverType.valueOf(getProperties("browser")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeScenario() throws IOException {
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getProperties("homeUrl"));
    }

    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }
}