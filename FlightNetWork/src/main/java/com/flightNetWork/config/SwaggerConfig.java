package com.flightNetWork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * This class used for documentation  configuration
 * @author vipin
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.basePackage("com.flightNetWork.resource")).paths(PathSelectors.any()).build().pathMapping("/").
				apiInfo(metadata()).groupName("FLIGHT");
	}

	private ApiInfo metadata() {

       return new ApiInfoBuilder().title("FlightNetWork API").description("Flight Management").version("1.01").licenseUrl("https://www.flightnetwork.com").termsOfServiceUrl("https://www.flightnetwork.com/").build();
                
    }
}
