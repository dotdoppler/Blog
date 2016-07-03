package com.doppler.blog.repositories;

import com.doppler.blog.models.RecentPosts;

/**
 * Created by doppler on 2016/5/26.
 */
public interface RecentPostsRepository {
    RecentPosts findByPostId(String postId);
}
