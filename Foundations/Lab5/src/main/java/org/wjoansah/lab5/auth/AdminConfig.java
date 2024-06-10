package org.wjoansah.lab5.auth;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AdminConfig {
    @Value("${application.admin.name}")
    private String name;

    @Value("${application.admin.email}")
    private String email;

    @Value("${application.admin.password}")
    private String password;
}
