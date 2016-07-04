package com.doppler.blog.dao;

import com.doppler.blog.models.Setting;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by doppler on 2016/7/3.
 */
@Component
public class SettingDao extends BaseDao {

    public Setting getSetting(){
        return this.sqlSession.selectOne("find");
    }
    @Transactional
    public void updateSetting(Setting setting) {
        this.sqlSession.update("updateSetting",setting);
    }
}
