package com.bookStore.myBookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(basePackages = {"service", "controller", "configuratin"})
@EntityScan(basePackages = "model")
public class MyBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBookStoreApplication.class, args);
	}

}
