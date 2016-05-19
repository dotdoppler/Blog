package mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by doppler on 2016/5/19.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("mongo")
@EnableMongoRepositories
public class MongoTestRun {
    public static void main(String[] args) {
        SpringApplication.run(MongoTestRun.class);
    }
}
