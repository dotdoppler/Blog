package com.doppler.blog.repositories;

import com.doppler.blog.models.Setting;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by doppler on 2016/5/28.
 */
public interface SettingRepository extends MongoRepository<Setting,String>{
}
