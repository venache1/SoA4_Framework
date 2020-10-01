package com.endava.soa4.stepdefs;

import com.endava.soa4.DriverManager;
import com.endava.soa4.DriverManagerFactory;
import com.endava.soa4.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

import static com.endava.soa4.utils.PropertyLoader.getProperties;

public class Hooks {
    DriverManager driverManager;

    {
        try {
            driverManager = DriverManagerFactory.getManager(DriverType.valueOf(getProperties("browser")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeScenario() throws IOException {
        driverManager.getDriver().get(getProperties("homeUrl"));
    }

    @After
    public void afterScenario() {
        driverManager.quitDriver();
    }
}