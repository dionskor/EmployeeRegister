package com.lucien.EmployeeRegister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeRegisterApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeRegisterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegisterApplication.class, args);
	}

}
