package com.fedex.upstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:upstream-system.properties")
public class UpStreamSystemApplication {

	public static void main(String[] args) { 
		SpringApplication.run(UpStreamSystemApplication.class, args);

	}

}
