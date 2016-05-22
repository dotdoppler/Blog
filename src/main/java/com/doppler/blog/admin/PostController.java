package com.doppler.blog.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by doppler on 2016/5/22.
 */
@Controller
@RequestMapping("admin/posts")
public class PostController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "admin/posts/index";
    }
    @RequestMapping(value = "new",method = RequestMethod.GET)
    public String newPost(Model model){

        return "admin/posts/new";
    }
}
