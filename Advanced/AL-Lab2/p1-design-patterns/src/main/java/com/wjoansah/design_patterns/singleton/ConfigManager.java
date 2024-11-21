package com.wjoansah.design_patterns.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager instance;
    private final Properties properties = new Properties();

    private ConfigManager() {
        loadPropertiesFromFile("C:\\Users\\WonderfulOwusu-ansah\\JavaLabs\\Advanced\\AL-Lab2\\p1-design-patterns\\src\\main\\java\\com\\wjoansah\\design_patterns\\singleton\\config.properties");
        overrideWithEnvironmentVariables();
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadPropertiesFromFile(String filePath) {
        System.out.println("current directory: " + System.getProperty("user.dir"));
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
        }
    }

    private void overrideWithEnvironmentVariables() {
        properties.forEach((key, value) -> {
            String envValue = System.getenv((String) key);
            if (envValue != null) {
                properties.setProperty((String) key, envValue);
            }
        });
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
