package com.doppler.blog.controllers;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.Service.SettingService;
import com.doppler.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by doppler on 2016/5/10.
 */
@Controller
public class HomeController {
    @Resource
    PostService postService;
    @Resource
    SettingService settingService;
    @RequestMapping(value = {"","home"}, method = GET)
    public String index(Model model){
        List<Post> recentPosts = postService.getRecentPosts();
        model.addAttribute("recentPosts",recentPosts);
        model.addAttribute("settings", settingService.getSetting());
        return "home/index";
    }
    @RequestMapping(value = "about")
    public String about(){
        return "home/about";
    }
}
