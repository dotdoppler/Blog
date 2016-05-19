package mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/19.
 */
public interface PersonRepository extends MongoRepository<Person,String>{

}
