package com.doppler.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.doppler.blog")
public class Application extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
