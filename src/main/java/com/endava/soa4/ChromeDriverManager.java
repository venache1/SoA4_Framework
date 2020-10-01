package com.endava.soa4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {
    private ChromeDriverService chService;

    @Override
    protected void startService() {
        if (null == chService) {
            try {
                File driverExecutable = new File(ClassLoader.getSystemResource("drivers/chromedriver.exe").toURI());
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(driverExecutable)
                        .usingAnyFreePort()
                        .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        driver = new ChromeDriver(chService, options);
    }
}
