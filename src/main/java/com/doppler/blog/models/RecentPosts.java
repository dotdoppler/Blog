package com.doppler.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by doppler on 2016/5/26.
 * capped collection "recent_posts" with 3 documents at most
 * db.createCollection("recent_posts",{"capped" : true, "size" : 512, "max" : 3})

 *
 */
@Document(collection = "recent_posts")
public class RecentPosts implements Serializable {

    private static final long serialVersionUID = -8339474637436161272L;
    @Id
    private String id;
    @Field(value = "postId")
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
