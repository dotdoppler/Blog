package com.doppler.blog.Service;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.repositories.PostRepository;
import com.doppler.blog.utils.Markdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by doppler on 2016/5/23.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    MongoOperations mongoOperations;
    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        return postRepository.insert(post);
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
}
