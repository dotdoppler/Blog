package com.doppler.blog.Service;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.RecentPosts;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.repositories.PostRepository;
import com.doppler.blog.repositories.RecentPostsRepository;
import com.doppler.blog.utils.Markdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doppler on 2016/5/23.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RecentPostsRepository recentPostsRepository;
    @Autowired
    MongoOperations mongoOperations;
    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        post = postRepository.insert(post);
        RecentPosts recentPosts = new RecentPosts();
        recentPosts.setPostId(post.getId());
        recentPostsRepository.insert(recentPosts);
        return post;
    }
    public List<Post> getPublishedPosts(){
        return postRepository.findAllPostsByStatus(PostStatus.PUBLISHED);
    }

    public Post getById(String postId){
        return postRepository.findOne(postId);
    }

    public List<Post> findAllPosts(){
        return postRepository.findAll();
    }
    public void deletePost(String postId){
        postRepository.delete(postId);
    }
    public void updatePost(Post post){
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
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
