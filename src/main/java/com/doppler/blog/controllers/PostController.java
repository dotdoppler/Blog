package com.doppler.blog.controllers;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by doppler on 2016/5/24.
 */
@Controller
@RequestMapping(value = "posts")
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping(value = "archive",method = RequestMethod.GET)
    public String archive(Model model){
        List<Post> posts =  postService.getPulishedPosts();
        model.addAttribute("posts" , posts);
        return "posts/archive";
    }
    @RequestMapping(value = "{postId}",method = RequestMethod.GET)
    public String showPosts(@PathVariable String postId, Model model){
        Post post = postService.getById(postId);
        model.addAttribute("post",post);
        return "posts/post";
    }
}
