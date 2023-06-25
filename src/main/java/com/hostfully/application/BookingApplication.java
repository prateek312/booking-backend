package com.hostfully.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.hostfully.application")
@EnableSwagger2
public class BookingApplication {

    public static void main(String[] args) {
        System.out.println("Hello there");
        SpringApplication.run(BookingApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*") // Replace with the URL of your frontend application
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*");
        }
    }
}
