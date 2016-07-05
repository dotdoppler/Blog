package com.doppler.blog.dao;

import com.doppler.blog.models.User;
import org.springframework.stereotype.Component;

/**
 * Created by doppler on 2016/7/4.
 */
@Component
public class UserDao extends BaseDao{

    public User findByUsername(String username) {
        return sqlSession.selectOne("findByUsername",username);
    }

    public void updateUser(User user) {
        sqlSession.update("updateUser",user);
    }
}
