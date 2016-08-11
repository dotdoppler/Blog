package com.doppler.blog.controllers;

import com.doppler.blog.Service.HashtagService;
import com.doppler.blog.Service.PostService;
import com.doppler.blog.models.Hashtag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by doppler on 2016/5/31.
 */
@Controller
@RequestMapping("hashtag")
public class TagController {
    @Resource
    HashtagService hashtagService;
    @Resource
    PostService postService;

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public String AllTag(Model model){
        model.addAttribute("allHashtags",hashtagService.findAll());
        return "hashtags/index";
    }
    @RequestMapping(value = "{tagName}",method = RequestMethod.GET)
        public String showPosts(@PathVariable String tagName,Model model){
        Hashtag hashtag = hashtagService.findByName(tagName);
        checkState(!(hashtag == null || hashtag.getName().isEmpty()),"Not Found");
        model.addAttribute("hashtag",hashtag.getName());
        model.addAttribute("posts",postService.getPostsByTag(hashtag.getName()));
        return "hashtags/list";
    }
}


