package com.doppler.blog.dao;

import com.doppler.blog.models.Hashtag;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by doppler on 2016/7/4.
 */
@Component
public class HashtagDao extends BaseDao{
    public  Hashtag findTagByName(String name){
        return sqlSession.selectOne("findTagByName",name);
    }

    public List<Hashtag> findAll() {
        return sqlSession.selectList("findAllTags");
    }
}
