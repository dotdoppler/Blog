package com.doppler.blog.repositories;

import com.doppler.blog.models.Hashtag;

/**
 * Created by doppler on 2016/5/30.
 */
public interface HashtagRepository {
    Hashtag findByName(String name);
}
