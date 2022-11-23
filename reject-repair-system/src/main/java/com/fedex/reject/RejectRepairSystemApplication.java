package com.fedex.reject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("reject-repair.properties")
public class RejectRepairSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RejectRepairSystemApplication.class, args);
	}

}
