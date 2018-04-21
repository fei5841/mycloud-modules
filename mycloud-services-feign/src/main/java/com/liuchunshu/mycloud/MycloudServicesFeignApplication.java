package com.liuchunshu.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
public class MycloudServicesFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycloudServicesFeignApplication.class, args);
	}
}
