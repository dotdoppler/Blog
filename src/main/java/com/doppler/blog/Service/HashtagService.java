package com.doppler.blog.Service;

import com.doppler.blog.GlobalConstants;
import com.doppler.blog.models.Hashtag;
import com.doppler.blog.repositories.HashtagRepository;
import com.doppler.blog.utils.DateFormatter;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by doppler on 2016/5/30.
 */
@Service
public class HashtagService {
    @Resource
    HashtagRepository hashtagRepository;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HashtagService.class);
    public Hashtag findOrCreateByName(String name){
        Hashtag hashtag = hashtagRepository.findByName(name);
        if(hashtag == null) {
            hashtag = new Hashtag(name);
            hashtag.setCreatedAt(DateFormatter.format(new Date()));
            hashtagRepository.insert(hashtag);
            logger.info(GlobalConstants.INSERTHASHTAG.value());
        }
        return hashtag;
    }
    public Hashtag findByName(String tagName){
        return hashtagRepository.findByName(tagName);
    }
    public List<Hashtag> findAll(){
        return hashtagRepository.findAll();
    }

    public void deleteTag(String hashtagId) {
        hashtagRepository.delete(hashtagId);
    }
}
