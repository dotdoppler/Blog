package com.doppler.blog.dao;

import com.doppler.blog.models.Setting;
import org.springframework.stereotype.Component;

/**
 * Created by doppler on 2016/7/3.
 */
@Component
public class SettingDao extends BaseDao {

    public Setting getSetting(){
        return this.sqlSession.selectOne("find");
    }
}
