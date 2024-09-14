package org.wjoansah.ex1springsecurityjwtauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    @Value("${application.admin.name}")
    private String name;

    @Value("${application.admin.email}")
    private String email;

    @Value("${application.admin.password}")
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
