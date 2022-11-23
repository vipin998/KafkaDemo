package com.flightNetWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightNetWorkApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		setSpringProfile();
		SpringApplication.run(FlightNetWorkApplication.class, args);
		System.out.println("***************Flight**Network**************");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}

	private static void setSpringProfile() {

		String profile = System.getProperty("spring.profiles.active", "local");
		System.out.println("SpringProfile" + profile);

		if (profile == null || profile.isEmpty()) {

			System.setProperty("spring.profiles.active", "local");
			System.err.println("No Spring profile supplied setting spring.profiles.active to local");

		} else if (profile != null & (profile.equalsIgnoreCase("local") || profile.equalsIgnoreCase("junit")
				|| profile.equalsIgnoreCase("test"))) {

			return;
		} else {

			System.setProperty("spring.profiles.active", "server" + profile);
		}
	}
}
