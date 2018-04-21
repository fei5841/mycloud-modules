package com.liuchunshu.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MycloudServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycloudServicesApplication.class, args);
	}
}
