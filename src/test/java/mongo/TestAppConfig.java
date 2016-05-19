package mongo;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by doppler on 2016/5/19.
 */
public class TestAppConfig {
    public @Bean Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydatabase");
    }
}
