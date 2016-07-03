package com.doppler.blog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by doppler on 2016/7/3.
 */
public class BaseDao {
    @Autowired
    protected SqlSession sqlSession;
}
