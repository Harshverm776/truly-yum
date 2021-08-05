package com.ct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Loan1Application {

	public static void main(String[] args) {
		SpringApplication.run(Loan1Application.class, args);
	}

}
