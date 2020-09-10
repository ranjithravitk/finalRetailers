package com.cts.RetailersMiddleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableJpaRepositories("com.cts.repository")
@EntityScan("com.cts.modal")
public class RetailersMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailersMiddlewareApplication.class, args);
	}

}
