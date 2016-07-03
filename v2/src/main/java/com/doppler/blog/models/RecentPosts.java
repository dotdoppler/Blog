package com.doppler.blog.models;

import java.io.Serializable;

/**
 * Created by doppler on 2016/5/26.
 * capped collection "recent_posts" with 3 documents at most
 * db.createCollection("recent_posts",{"capped" : true, "size" : 512, "max" : 3})

 *
 */

public class RecentPosts implements Serializable {

    private static final long serialVersionUID = -8339474637436161272L;
    private String id;
    private String postId;

    public RecentPosts() {
    }

    public RecentPosts(String postId){
        this.postId = postId;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
