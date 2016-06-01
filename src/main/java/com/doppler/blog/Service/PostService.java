package com.doppler.blog.Service;

import com.doppler.blog.GlobalConstants;
import com.doppler.blog.models.Post;
import com.doppler.blog.models.RecentPosts;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.repositories.PostRepository;
import com.doppler.blog.repositories.RecentPostsRepository;
import com.doppler.blog.utils.DateFormatter;
import com.doppler.blog.utils.Markdown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by doppler on 2016/5/23.
 */
@Service
public class PostService {
    @Resource
    private PostRepository postRepository;
    @Resource
    private RecentPostsRepository recentPostsRepository;
    @Resource
    MongoOperations mongoOperations;
    @Resource
    HashtagService hashtagService;

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        post.setCreatedAt(DateFormatter.format(new Date()));
        post = postRepository.insert(post);
        logger.info(GlobalConstants.INSERTPOST.value() + post.getTitle());
        recentPostsRepository.insert(new RecentPosts(post.getId()));
        return post;
    }
    public List<Post> getPublishedPosts(){
        return postRepository.findAllPostsByStatus(PostStatus.PUBLISHED,new Sort(Sort.Direction.DESC,"_id"));
    }

//    public Page<Post> getPublishedPostsByPage(int page, int pageSize){
//        Pageable pageRequest = new PageRequest(page, pageSize, Sort.Direction.DESC, "_id");
//        return postRepository.findAllPostsByStatusAndPage(PostStatus.PUBLISHED, pageRequest);
//    }

    public Post getById(String postId){
        return postRepository.findOne(postId);
    }
    public Post getByLink(String postLink){
        return postRepository.getByLink(postLink);
    }

    public List<Post> findAllPosts(){
        return postRepository.findAll(new Sort(Sort.Direction.DESC,"_id"));
    }

    public void deletePost(String postId){
        postRepository.delete(postId);
        logger.info(GlobalConstants.DELETEPOST.value() + postId);
    }
    public void updatePost(Post post){
        if (post.getPostFormat() == PostFormat.MARKDOWN)
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        post.setUpdatedAt(DateFormatter.format(new Date()));

        if(recentPostsRepository.findByPostId(post.getId()) == null)
        recentPostsRepository.insert(new RecentPosts(post.getId()));
        mongoOperations.save(post);
        logger.info(GlobalConstants.UPDATEPOST.value() + post.getTitle());
    }
    public List<Post> getRecentPosts(){
        List<Post> recentPosts = null;
        List<RecentPosts> list = recentPostsRepository.findAll();
        if (list.size() > 0){
            recentPosts = new ArrayList<Post>();
            Post post = null;
            for(int i = list.size() - 1;i > -1;i--) {
                post = postRepository.findOne(list.get(i).getPostId());
                if (post != null)
                recentPosts.add(post);
            }
        }
        return recentPosts;
    }

    public Set<String> parseHashtagStr(String hashtags_str){
        Set<String> hashtags = new HashSet<String>();
        if(hashtags_str != null && !hashtags_str.isEmpty()){
            String names[] = hashtags_str.split("\\s*,\\s*");
            for(String name : names)
                hashtags.add(hashtagService.findOrCreateByName(name).getName());
        }
        return hashtags;
    }

    public String getHashtags_str(Set<String> hashtags) {
        if (hashtags == null || hashtags.isEmpty())
            return "";
        StringBuilder hashtags_str = new StringBuilder("");
        hashtags.forEach(hashtag -> hashtags_str.append(hashtag).append(","));
        hashtags_str.deleteCharAt(hashtags_str.length() - 1);
        return hashtags_str.toString();
    }

    public List<Post> getPostsByTag(String tagName) {
        return postRepository.getByHashtag(tagName,new Sort(Sort.Direction.DESC,"_id"));
    }
}
