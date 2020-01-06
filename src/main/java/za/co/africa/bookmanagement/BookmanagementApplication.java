package za.co.africa.bookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookmanagementApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BookmanagementApplication.class, args);
	}

}
