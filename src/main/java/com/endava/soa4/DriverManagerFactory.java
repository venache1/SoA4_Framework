package com.endava.soa4;

public class DriverManagerFactory {
 private static DriverManager driverManager;

    public static DriverManager getManager(DriverType type) {
        switch (type) {
            case CHROME:
                return getChromeDriverManager();
            case FIREFOX:
                return getFirefoxDriverManager();
            default:
                throw new IllegalStateException("Unexpected browser type: " + type);
        }
    }

    private static DriverManager getChromeDriverManager() {
        if (driverManager == null){
            driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }
    private static DriverManager getFirefoxDriverManager() {
        if (driverManager == null){
            driverManager = new FirefoxDriverManager();
        }
        return driverManager;
    }
}
