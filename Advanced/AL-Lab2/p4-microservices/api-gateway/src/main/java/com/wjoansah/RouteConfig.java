package com.wjoansah;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("user-service-route", r -> r
                        .path("/users/**")
                        .and()
                        .header("redirect", "order")
                        .filters(f -> f
                                .addResponseHeader("Redirect-Status", "true")
                                .setPath("/orders")
                        )
                        .uri("lb://order-service"))

                .route("user-service", r -> r
                        .path("/user-service/**")
                        .filters(f -> f
                                .circuitBreaker(config -> config
                                        .setName("userServiceBreaker")
                                        .setFallbackUri("forward:/fallback")
                                        .setRouteId("user-service-route")
                                )
                                .setPath("/users")
                        )
                        .uri("lb://user-service"))

                .build();
    }
}
