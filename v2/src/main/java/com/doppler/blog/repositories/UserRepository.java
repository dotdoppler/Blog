package com.doppler.blog.repositories;

import com.doppler.blog.models.User;

/**
 * Created by doppler on 2016/5/19.
 */
public interface UserRepository  {
    User findByEmail(String email);
    User findByUsername(String username);
}
