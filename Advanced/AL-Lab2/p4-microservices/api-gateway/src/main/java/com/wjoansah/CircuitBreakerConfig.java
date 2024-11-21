package com.wjoansah;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class CircuitBreakerConfig {

    @Bean
    public RouterFunction<ServerResponse> fallbackResponseRoute() {
        return RouterFunctions.route(
                RequestPredicates.path("/fallback"),
                request -> ServerResponse.ok().bodyValue("service unavailable")
        );
    }
}
