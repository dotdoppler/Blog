package com.doppler.blog.repositories;

import com.doppler.blog.models.Hashtag;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/30.
 */
public interface HashtagRepository extends MongoRepository<Hashtag,String>{
    Hashtag findByName(String name);
}
