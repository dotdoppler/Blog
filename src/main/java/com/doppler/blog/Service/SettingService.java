package com.doppler.blog.Service;

import com.doppler.blog.GlobalConstants;
import com.doppler.blog.models.Setting;
import com.doppler.blog.repositories.SettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SettingService {
    Logger logger = LoggerFactory.getLogger(SettingService.class);
    @Resource
    SettingRepository settingRepository;

    public Setting getSetting(){
        return settingRepository.findAll().get(0);
    }

    public  Setting updateSetting(Setting setting) {
       logger.info(GlobalConstants.UPDATESETTINGS.value() + new Date().toString());
        return settingRepository.insert(setting);
    }
}
