package com.doppler.blog.repositories;

import com.doppler.blog.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/19.
 */
public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
