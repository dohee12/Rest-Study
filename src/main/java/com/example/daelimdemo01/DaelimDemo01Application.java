package com.example.daelimdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class DaelimDemo01Application {

	public static void main(String[] args) {

		SpringApplication.run(DaelimDemo01Application.class, args);
	}
}
