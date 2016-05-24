package com.doppler.blog.Service;

import com.doppler.blog.models.Post;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.repositories.PostRepository;
import com.doppler.blog.utils.Markdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by doppler on 2016/5/23.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        if (post.getPostFormat() == PostFormat.MARKDOWN) {
            post.setRenderedContent(Markdown.markdownToHtml(post.getContent()));
        }
        return postRepository.save(post);
    }
    public List<Post> getPulishedPosts(){
        return postRepository.findAllPostsByStatus(PostStatus.PUBLISHED);
    }

    public Post getById(String postId){
        return postRepository.findById(postId);
    }
}
