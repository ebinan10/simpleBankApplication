package com.bankmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({"com.bankmanagementapp.repository","com.bankmanagementapp.entity","com.bankmanagementapp.controller"})
@EnableJpaRepositories("com.bankmanagementapp.repository")
public class SpringBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBankApplication.class, args);
	}

}
