package com.doppler.blog.repositories;

import com.doppler.blog.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/23.
 */
public interface PostRepository extends MongoRepository<Post,String> {
}
