package doppler.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("doppler")
public class Application extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
