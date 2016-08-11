package com.doppler.blog.controllers;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by doppler on 2016/5/24.
 */
@Controller
@RequestMapping(value = "posts")
public class PostController {
    @Resource
    PostService postService;
    @RequestMapping(value = {"archive",""},method = RequestMethod.GET)
    public String archive(Model model){
        model.addAttribute("posts", postService.getPublishedPosts());
        return "posts/archive";
    }
    @RequestMapping(value = "{postLink}",method = RequestMethod.GET)
    public String showPosts(@PathVariable String postLink, Model model){
        Post post = postService.getByLink(postLink);
        checkNotNull(postService.getByLink(postLink) != null,"Post Not Found");
        model.addAttribute("hashtags",post.getHashtags());
        model.addAttribute("post",post);
        return "posts/post";
    }
}
