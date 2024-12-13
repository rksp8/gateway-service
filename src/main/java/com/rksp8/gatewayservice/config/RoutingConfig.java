package com.rksp8.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**", "/login", "/oauth2/authorization/google")
                        .uri("lb://user-service"))
                .route("post-service", r -> r.path("/posts/**")
                        .uri("lb://post-service"))
                .route("rating-service", r -> r.path("/rating/**")
                        .uri("lb://rating-service"))
                .build();
    }
}
