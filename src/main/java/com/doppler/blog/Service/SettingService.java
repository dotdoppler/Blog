package com.doppler.blog.Service;

import com.doppler.blog.models.Setting;
import com.doppler.blog.repositories.SettingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SettingService {
    @Resource
    SettingRepository settingRepository;

    public Setting getSetting(){
        return settingRepository.findAll().get(0);
    }

    public  Setting updateSetting(Setting setting) {
       return settingRepository.insert(setting);
    }
}
