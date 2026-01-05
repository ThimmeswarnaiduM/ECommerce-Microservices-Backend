package e_Commerce_project.Gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);


	}
      @Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/v1/products/**")
						.uri("lb://product-service"))
				.route(r -> r.path("/api/v1/orders/**")
						.uri("lb://order-service"))
				.route(r->r.path("/api/v1/payments/**")
						.uri("lb://payment-service"))
				.route(r->r.path("/api/v1/customers/**")
						.uri("lb://customer-service"))

				.build();
	}
}
