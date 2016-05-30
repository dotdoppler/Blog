package com.doppler.blog.Service;

import com.doppler.blog.models.Hashtag;
import com.doppler.blog.repositories.HashtagRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by doppler on 2016/5/30.
 */
@Service
public class HashtagService {
    @Resource
    HashtagRepository hashtagRepository;

    Hashtag findOrCreateByName(String name){
        Hashtag hashtag = hashtagRepository.findByName(name);
        if(hashtag == null) {
            hashtag = new Hashtag(name);
            hashtagRepository.insert(hashtag);
        }
        return hashtag;
    }


}
