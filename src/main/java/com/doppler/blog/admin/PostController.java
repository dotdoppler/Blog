package com.doppler.blog.admin;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.forms.PostForm;
import com.doppler.blog.models.Post;
import com.doppler.blog.models.User;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by doppler on 2016/5/22.
 */
@Controller("adminPostController")
@RequestMapping("admin/posts")
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "admin/posts/index";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String create(@Valid PostForm postForm,Model model){
        Post post = DTOUtil.map(postForm, Post.class);
        post.setUser(new User());
       // post.setTags(postService.parseTagNames(postForm.getPostTags()));

        postService.createPost(post);

        return "redirect:/admin/posts";
    }

    @RequestMapping(value = "new",method = RequestMethod.GET)
    public String newPost(Model model){
        PostForm postForm = DTOUtil.map(new Post(), PostForm.class);
        postForm.setPostTags("");

        model.addAttribute("postForm", postForm);
        model.addAttribute("postFormats", PostFormat.values());
        model.addAttribute("postStatus", PostStatus.values());
        return "admin/posts/new";
    }
}
