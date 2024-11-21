package com.wjoansah.design_patterns.singleton;

public class Runner {
    public static void main(String[] args) {
        ConfigManager configManager = ConfigManager.getInstance();

        String dbUrl = configManager.getProperty("db.url");
        String dbUser = configManager.getProperty("db.user");
        String dbPassword = configManager.getProperty("db.password", "defaultPassword");

        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database User: " + dbUser);
        System.out.println("Database Password: " + dbPassword);
    }
}
