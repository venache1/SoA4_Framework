package com.endava.soa4;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class FirefoxDriverManager extends DriverManager {
    private GeckoDriverService ffService;

    @Override
    protected void startService() {
        if (null == ffService) {
            try {
                File driverExecutable = new File(ClassLoader.getSystemResource("drivers/geckodriver.exe").toURI());
                ffService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(driverExecutable)
                        .usingAnyFreePort()
                        .build();

                ffService.start();
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != ffService && ffService.isRunning()) {
            ffService.stop();
        }
    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        driver = new FirefoxDriver(ffService, options);
    }
}
