package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserApplicaton {

	public static void main(String[] args) {
		new SpringApplication(UserApplicaton.class).run(args);
	}
}
