package com.doppler.blog.dao;

import com.doppler.blog.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by doppler on 2016/7/3.
 */
@Component
public class PostDao extends BaseDao{

    public List<Post> findRecentPosts(){
        return sqlSession.selectList("findRecentPosts");
    };
}
