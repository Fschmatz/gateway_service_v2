package com.fschmatz.gateway_service_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceV2Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceV2Application.class, args);
	}

	/*@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route( p -> p
						.path("/get")
						.uri("https://www.google.com/search?q="))
				.route( p -> p
						.path("/homeTeste")

						.uri("localhost:9090//"))
				.build();
	}*/

}
