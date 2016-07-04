package com.doppler.blog.mappers;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by doppler on 2016/7/3.
 */
@Mapper
public interface PostMapper {
    List<Post> findRecentPosts();
    List<Post> findAllPostsByStatus(@Param("postStatus") PostStatus postStatus);
    Post getPostById(@Param("postId") Long postId);
    Post getByLink(@Param("postLink") String postLink);
    List<Post> findAllPosts();
    List<Post> getPostsByHashtag(@Param("tagName") String tagName);
}
