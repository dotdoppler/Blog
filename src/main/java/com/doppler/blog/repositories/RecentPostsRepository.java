package com.doppler.blog.repositories;

import com.doppler.blog.models.RecentPosts;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/26.
 */
public interface RecentPostsRepository extends MongoRepository<RecentPosts , String> {
}
