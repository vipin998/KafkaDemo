package com.fedex.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:invoice.properties")
public class InvoiceSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvoiceSystemApplication.class, args);

	}

}
