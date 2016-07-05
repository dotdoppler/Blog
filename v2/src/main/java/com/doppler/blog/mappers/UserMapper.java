package com.doppler.blog.mappers;

import com.doppler.blog.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by doppler on 2016/7/4.
 */
@Mapper
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    void updateUser(User user);
}
