package com.doppler.blog.mappers;

import com.doppler.blog.models.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by doppler on 2016/7/3.
 */
@Mapper
public interface PostMapper {
    List<Post> findRecentPosts();
}
