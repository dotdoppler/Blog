package com.doppler.blog.dao;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostStatus;
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

    public List<Post> findAllPostsByStatus(PostStatus postStatus){
        return sqlSession.selectList("findAllPostsByStatus",postStatus);
    }

    public Post getById(Long postId) {
        return sqlSession.selectOne("getById",postId);
    }

    public Post getByLink(String postLink) {
        return sqlSession.selectOne("getByLink",postLink);
    }

    public List<Post> findAll() {
        return sqlSession.selectList("findAll");
    }
}
