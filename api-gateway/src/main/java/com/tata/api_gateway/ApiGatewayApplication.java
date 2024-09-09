package com.tata.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

//@Bean
//    public RouteLocator  customRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("service1", r -> r.path("/api/v1/client/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://CLIENT-MICROSERVICES"))
//                .build();
//    }

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
