package e_Commerce_project.productservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Product service API Documents",
				description = "Product service Api complete documents for E-commerece service",
		contact = @Contact(
				email = "thimmeswaranaidu@gmai.com",
				name = "Thimmeswaranaidu"

		)
		),
		servers = @Server(
				url = "http:localhost://8091"

		)


)
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
