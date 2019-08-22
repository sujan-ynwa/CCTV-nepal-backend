package com.summerproject.cctvnepal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class CctvnepalApplication {
	public static void main(String[] args) {
		SpringApplication.run(CctvnepalApplication.class, args);
	}

}
