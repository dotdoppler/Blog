package com.doppler.blog.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doppler on 2016/5/23.
 */
public class Hashtag extends BaseModel {


    private static final long serialVersionUID = 704937242013239319L;
    private  String  name;
    private Set<Post> posts = new HashSet<>();

    public Hashtag() {
    }

    public Hashtag(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
