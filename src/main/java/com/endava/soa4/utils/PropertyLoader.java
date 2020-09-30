package com.endava.soa4.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    public static String getProperties(String key) throws IOException {
        Properties prop = new Properties();
        try (InputStream ip = ClassLoader.getSystemResourceAsStream("config/config.properties")) {
            prop.load(ip);
        }
        return prop.getProperty(key);
    }
}
