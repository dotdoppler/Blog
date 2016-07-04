package com.doppler.blog.controllers;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.exception.NotFoundException;
import com.doppler.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

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
        model.addAttribute("posts",  postService.getPublishedPosts());
        return "posts/archive";
    }
    @RequestMapping(value = "{postLink}",method = RequestMethod.GET)
    public String showPosts(@PathVariable String postLink, Model model){
        Post post = postService.getByLink(postLink);
        if (post == null)
            throw new  NotFoundException("");
        model.addAttribute("post",post);
        return "posts/post";
    }
}
