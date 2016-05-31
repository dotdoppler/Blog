package com.doppler.blog.admin;

import com.doppler.blog.Service.PostService;
import com.doppler.blog.forms.PostForm;
import com.doppler.blog.models.Post;
import com.doppler.blog.models.User;
import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import com.doppler.blog.utils.DTOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by doppler on 2016/5/22.
 */
@Controller("adminPostController")
@RequestMapping("admin/posts")
public class PostController {
    @Resource
    PostService postService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model){
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts",posts);

        return "admin/posts/index";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String create(@Valid PostForm postForm,Model model){
        Post post = DTOUtil.map(postForm, Post.class);
        post.setUser(new User());
        post.setHashtags(postService.parseHashtagStr(postForm.getHashtags()));

        postService.createPost(post);

        return "redirect:/admin/posts";
    }
    @RequestMapping(value = "{postId}",method = RequestMethod.DELETE)
    public @ResponseBody String deletePost(@PathVariable String postId){
        postService.deletePost(postId);
        return null;
    }
    @RequestMapping(value = "{postId}",method = {RequestMethod.POST,RequestMethod.PUT})
    public  String updatePost(@PathVariable String postId,@Valid PostForm postForm){
        Post post = postService.getById(postId);
        DTOUtil.mapTo(postForm, post);
        post.setHashtags(postService.parseHashtagStr(postForm.getHashtags()));
        postService.updatePost(post);
        return  "redirect:/admin/posts";
    }

    @RequestMapping(value = "new",method = RequestMethod.GET)
    public String newPost(Model model){
        PostForm postForm = DTOUtil.map(new Post(), PostForm.class);
        postForm.setHashtags("");

        model.addAttribute("postForm", postForm);
        model.addAttribute("postFormats", PostFormat.values());
        model.addAttribute("postStatus", PostStatus.values());
        return "admin/posts/new";
    }

    @RequestMapping(value = "{postId}/edit")
    public String editPost(@PathVariable String postId, Model model){
        Post post = postService.getById(postId);
        PostForm postForm = DTOUtil.map(post, PostForm.class);
        postForm.setHashtags(postService.getHashtags_str(post.getHashtags()));
        model.addAttribute("post", post);
        model.addAttribute("postForm", postForm);
        model.addAttribute("postFormats", PostFormat.values());
        model.addAttribute("postStatus", PostStatus.values());

        return "admin/posts/edit";
    }
}
