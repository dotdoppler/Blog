package com.doppler.blog.Service;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.RecentPosts;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.repositories.PostRepository;
import com.doppler.blog.repositories.RecentPostsRepository;
import com.doppler.blog.utils.DateFomater;
import com.doppler.blog.utils.Markdown;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        post.setCreatedAt(DateFomater.format(new Date()));
        post = postRepository.insert(post);
        recentPostsRepository.insert(new RecentPosts(post.getId()));
        return post;
    }
    public List<Post> getPublishedPosts(){
        return postRepository.findAllPostsByStatus(PostStatus.PUBLISHED,new Sort(Sort.Direction.DESC,"_id"));
    }

    public Page<Post> getPublishedPostsByPage(int page, int pageSize){
        Pageable pageRequest = new PageRequest(page, pageSize, Sort.Direction.DESC, "_id");
        return postRepository.findAllPostsByStatusAndPage(PostStatus.PUBLISHED, pageRequest);
    }

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
    }
    public void updatePost(Post post){
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        post.setUpdatedAt(DateFomater.format(new Date()));
        recentPostsRepository.insert(new RecentPosts(post.getId()));
        mongoOperations.save(post);
    }
    public List<Post> getRecentPosts(){
        List<Post> recentPosts = null;
        List<RecentPosts> list = recentPostsRepository.findAll();
        if (list.size() > 0){
            recentPosts = new ArrayList<Post>();
            for(int i = list.size() - 1;i > -1;i--)
                recentPosts.add(postRepository.findOne(list.get(i).getPostId()));
        }
        return recentPosts;
    }

}
