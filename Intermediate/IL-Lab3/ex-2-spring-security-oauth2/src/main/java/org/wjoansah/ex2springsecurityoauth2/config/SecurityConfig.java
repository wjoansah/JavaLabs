package org.wjoansah.ex2springsecurityoauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.PathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    final String[] WHITELIST = {
            "/",
            "/api/auth/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, PathMatcher mvcPathMatcher) throws Exception {
        http
                .authorizeHttpRequests(authn -> {
                    authn.requestMatchers(WHITELIST).permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
                            .anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}
