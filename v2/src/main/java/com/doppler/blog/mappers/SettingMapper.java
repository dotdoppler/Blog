package com.doppler.blog.mappers;

import com.doppler.blog.models.Setting;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by doppler on 2016/7/3.
 */
@Mapper
public interface SettingMapper {
    Setting find();
    void updateSetting(Setting setting);
}
