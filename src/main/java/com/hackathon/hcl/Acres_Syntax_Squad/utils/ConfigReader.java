package com.hackathon.hcl.Acres_Syntax_Squad.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/main/resources/config.properties");

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
    
    public static String getLocation() {
        return properties.getProperty("location");
    }
}