package e_Commerce_project.customer;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(
		info=@Info(
				title="Customer Service API",
				version="1.0",
				description="This is an API for managing customers.",
       contact =@Contact(
			   name="E-commerce",
			   email="e-commerce@gmail.com"
	   )
		),
		servers={
				@Server(
						url="http://localhost:8090",
						description="Local Server"
				),

		}
)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
