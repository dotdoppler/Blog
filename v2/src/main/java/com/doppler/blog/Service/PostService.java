package com.doppler.blog.Service;

import com.doppler.blog.GlobalConstants;
import com.doppler.blog.mappers.PostMapper;
import com.doppler.blog.models.Hashtag;
import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.utils.DateFormatter;
import com.doppler.blog.utils.Markdown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by doppler on 2016/5/23.
 */
@Service
public class PostService {
//    @Resource
//    private PostDao postDao;
    @Resource
    private PostMapper postMapper;
    @Resource
    HashtagService hashtagService;

    private static final String CACHE_POST_ARCHIVE = "post_archive";
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @CacheEvict(value = CACHE_POST_ARCHIVE, allEntries = true)
    @Transactional
    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        post.setCreatedAt(DateFormatter.format(new Date()));
        postMapper.insertPost(post);
        logger.info(GlobalConstants.INSERTPOST.value() + post.getTitle());
        return post;
    }

    @Cacheable(value = CACHE_POST_ARCHIVE)
    public List<Post> getPublishedPosts(){
        logger.info("not cache,get post archive form db");
        return postMapper.findAllPostsByStatus(PostStatus.PUBLISHED);
    }

//    public Page<Post> getPublishedPostsByPage(int page, int pageSize){
//        Pageable pageRequest = new PageRequest(page, pageSize, Sort.Direction.DESC, "_id");
//        return postRepository.findAllPostsByStatusAndPage(PostStatus.PUBLISHED, pageRequest);
//    }

    public Post getPostById(Long postId){
        return  postMapper.getPostById(postId);
    }

    public Post getByLink(String postLink){
        return postMapper.getByLink(postLink);
    }

    public List<Post> findAllPosts(){
        return postMapper.findAllPosts();
    }

    @CacheEvict(value = CACHE_POST_ARCHIVE, allEntries = true)
    public void deletePost(String postId){
        //postRepository.delete(postId);
        logger.info(GlobalConstants.DELETEPOST.value() + postId);
    }
    @CacheEvict(value = CACHE_POST_ARCHIVE, allEntries = true)
    public void updatePost(Post post){
        if (post.getPostFormat() == PostFormat.MARKDOWN)
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        post.setUpdatedAt(DateFormatter.format(new Date()));

//        if(recentPostsRepository.findByPostId(post.getId()) == null)
//        recentPostsRepository.insert(new RecentPosts(post.getId()));
//        mongoOperations.save(post);
        logger.info(GlobalConstants.UPDATEPOST.value() + post.getTitle());
    }
    public List<Post> getRecentPosts(){
       // return postDao.findRecentPosts();
        return postMapper.findAllPostsByStatus(PostStatus.PUBLISHED);
    }

    public Set<Hashtag> parseHashtagStr(String hashtags_str){
        Set<Hashtag> hashtags = new HashSet<>();
        if(hashtags_str != null && !hashtags_str.isEmpty()){
            String names[] = hashtags_str.split("\\s*,\\s*");
            for(String name : names)
                hashtags.add(hashtagService.findOrCreateByName(name));
        }
        return hashtags;
    }

    public String getHashtags_str(Set<Hashtag> hashtags) {
        if (hashtags == null || hashtags.isEmpty())
            return "";
        StringBuilder hashtags_str = new StringBuilder("");
        hashtags.forEach(hashtag -> hashtags_str.append(hashtag.toString()).append(","));
        hashtags_str.deleteCharAt(hashtags_str.length() - 1);
        return hashtags_str.toString();
    }

    public List<Post> getPostsByTag(String tagName) {

       return postMapper.getPostsByHashtag(tagName);
    }
}
