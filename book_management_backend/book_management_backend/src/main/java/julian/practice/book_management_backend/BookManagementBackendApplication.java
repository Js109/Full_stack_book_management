package julian.practice.book_management_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Enables Auto configuration, Component scanning, Additional configuration
Composed of @EnableAutoConfiguration, @ComponentScan (scans package and subpackages), @Configuration
 */
@SpringBootApplication
public class BookManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementBackendApplication.class, args);
	}

}
