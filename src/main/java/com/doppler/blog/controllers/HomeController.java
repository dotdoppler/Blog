package com.doppler.blog.controllers;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by doppler on 2016/5/10.
 */
@Controller
public class HomeController {
    @Autowired
    PostService postService;

    @RequestMapping(value = {"","home"}, method = GET)
    public String index(Model model){
        List<Post> posts = postService.getPulishedPosts();
        model.addAttribute("posts",posts);
        return "home/index";
    }
}
