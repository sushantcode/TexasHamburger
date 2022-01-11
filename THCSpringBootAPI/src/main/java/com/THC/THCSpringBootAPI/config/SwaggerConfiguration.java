package com.THC.THCSpringBootAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerUIConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.THC"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return  new ApiInfo(
                "Texas Hamburger Company APIs",
                "APIs to handle THC day to day business and administrative activities",
                "1.0",
                "Public use",
                new springfox.documentation.service.Contact("Sushant Gupta", "http://sushantcode.com", "sushantgupta2016@gmail.com"),
                "MIT License",
                "www.mitlicense.com",
                Collections.emptyList()
        );
    }
}
