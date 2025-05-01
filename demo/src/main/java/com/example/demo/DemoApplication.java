package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// http://localhost:8080/hello?name=dohee

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name
	){
		return String.format("Hello %s!", name);
	}

	@GetMapping("/get-random-number")
	public int getRandomNumber(@RequestParam(value = "max", defaultValue = "50") int max
	){
		System.out.println(max);
		return (int) Math.random() * max;
	}
}
