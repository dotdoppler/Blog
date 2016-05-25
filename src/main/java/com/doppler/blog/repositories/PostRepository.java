package com.doppler.blog.repositories;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by doppler on 2016/5/23.
 */
public interface PostRepository  extends MongoRepository<Post,String> {

    @Override
    Post findOne(String postId);

    @Override
    void delete(String postId);

    @Query("{'postStatus' : ?0}")
    List<Post> findAllPostsByStatus(PostStatus postStatus);
}
